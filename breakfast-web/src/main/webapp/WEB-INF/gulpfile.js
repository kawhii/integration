var gulp = require('gulp'),
    watch = require('gulp-watch');;
// 语法检查
gulp.task('watch-view', function () {
    return watch('views/**/*.ftl', { ignoreInitial: false })
        .pipe(gulp.dest('../../../../target/breakfast-web/WEB-INF/views/'));

});

gulp.task('watch-js', function () {
    return watch('resource/**/*.js', { ignoreInitial: false })
        .pipe(gulp.dest('../../../../target/breakfast-web/WEB-INF/resource/'));

});

gulp.task('watch-css', function () {
    return watch('resource/**/*.css', { ignoreInitial: false })
        .pipe(gulp.dest('../../../../target/breakfast-web/WEB-INF/resource/'));

});

gulp.task('watch-base', function () {
    return watch('resource/**/base/**/*.*', { ignoreInitial: false })
        .pipe(gulp.dest('../../../../target/breakfast-web/WEB-INF/resource/'));

});

gulp.task('default', ['watch-view', 'watch-js', 'watch-css', 'watch-base']);