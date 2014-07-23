'use strict';

module.exports = function (grunt) {

  require('load-grunt-tasks')(grunt);

  grunt.initConfig({
    watch: {
      js: {
        files: ['app/sansatout.js'],
        options: {
          livereload: true,
        }
      },
    },

    concurrent: {
      options: {
        logConcurrentOutput: true,
	limit: 2
      },
      build_and_watch: [
        'shell:cljs',
        'watch:js'
      ],
    },

    shell: {
      options: {
        stdout: true
      },
      cljs: {
        command: 'lein do cljsbuild clean, cljsbuild auto dev'
      }
    }
  });
  grunt.registerTask('default', ['concurrent:build_and_watch']);
};
