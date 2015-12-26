'use strict';

var gulp = require('gulp');
var fs = require('fs');
var replace = require('gulp-batch-replace');

gulp.task('prepareConfigGitSettings', function() {
    var replacementMap = [];
    
    var url = fs.readFileSync("/usr/gitRepos/repositoryUrl.txt", "utf8");
 	var userName = fs.readFileSync("/usr/gitRepos/userName.txt", "utf8");
 	var userPassword = fs.readFileSync("/usr/gitRepos/userPassword.txt", "utf8"); 	

    replacementMap.push(["toBeReplacedByRepositoryUrl", url]);
    replacementMap.push(["toBeReplacedByUserName", userName]);
    replacementMap.push(["toBeReplacedByUserPassword", userPassword]);

    gulp.src(['src/main/resources/templates/application.yaml'])
        .pipe(replace(replacementMap))
        .pipe(gulp.dest('src/main/resources/'));
});