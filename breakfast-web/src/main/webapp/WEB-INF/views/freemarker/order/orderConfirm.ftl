<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${data.goods.title!''}</title>
<#include "freemarker/base/base.ftl">
    <script type="text/javascript" src="/js/~/admin/index.js"></script>
    <link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>
</head>
<body>
<#include "freemarker/base/nav.ftl">

<script>
    var orderData = ${data!''};
</script>
</body>
</html>
