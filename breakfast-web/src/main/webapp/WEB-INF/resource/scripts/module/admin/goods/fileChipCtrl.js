/*文件选择控制器*/
function FileChipCtrl($q, $timeout, $request, $rootScope) {
    var self = this;
    var pendingSearch, cancelSearch = angular.noop;
    var cachedQuery = '', lastSearch;

    self.allContacts = [];
    self.asyncContacts = [];
    self.filterSelected = true;
    //允许获取图片
    $rootScope.getSelectFileData = function () {
        return self.asyncContacts;
    };

    self.delayedQuerySearch = delayedQuerySearch;

    /**
     * Search for contacts; use a random delay to simulate a remote call
     */
    function querySearch(criteria) {
        cachedQuery = cachedQuery || criteria;
        return cachedQuery ? self.allContacts.filter(createFilterFor(cachedQuery)) : [];
    }

    /**
     * Async search for contacts
     * Also debounce the queries; since the md-contact-chips does not support this
     */
    function delayedQuerySearch(criteria) {
        cachedQuery = criteria;
        loadContacts();
        if (!pendingSearch || !debounceSearch()) {
            cancelSearch();

            return pendingSearch = $q(function (resolve, reject) {
                // Simulate async search... (after debouncing)
                cancelSearch = reject;
                $timeout(function () {

                    resolve(querySearch());

                    refreshDebounce();
                }, Math.random() * 200, true)
            });
        }

        return pendingSearch;
    }

    function refreshDebounce() {
        lastSearch = 0;
        pendingSearch = null;
        cancelSearch = angular.noop;
    }

    /**
     * Debounce if querying faster than 300ms
     */
    function debounceSearch() {
        var now = new Date().getMilliseconds();
        lastSearch = lastSearch || now;

        return ((now - lastSearch) < 300);
    }

    /**
     * Create filter function for a query string
     */
    function createFilterFor(query) {
        var lowercaseQuery = angular.lowercase(query);

        return function filterFn(contact) {
            return (contact.uploadName.indexOf(lowercaseQuery) != -1);
        };
    }

    function loadContacts() {
        //渲染列表
        $request.get("/sys/file/list.json"
            , {page: 1, pageSize: 15, name: cachedQuery}
            , function (data) {
                if (data.header.code == 0) {
                    // self.asyncContacts = data.body.recordList;//recordList
                    self.allContacts = data.body.recordList;
                    angular.forEach(self.allContacts, function (item, index) {
                        item.tempVisitPath = '/file/img/~/' + item.visitPath;
                    });
                }
            });
    }

    loadContacts();
}