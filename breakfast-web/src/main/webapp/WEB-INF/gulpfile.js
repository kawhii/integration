var gulp = require('gulp'),
    watch = require('gulp-watch');;
// 语法检查
gulp.task('watch', function () {
    return watch('views/**/*.ftl', { ignoreInitial: false })
        .pipe(gulp.dest('../../../../target/breakfast-web/WEB-INF/views/'));

});

gulp.task('default', ['watch']);