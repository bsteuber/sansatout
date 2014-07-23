(defproject sansatout "1.0.0-SNAPSHOT"
  :description "GoPanda2 IGS client"
  :dependencies [[hiccups "0.2.0"]
                 [org.clojure/clojurescript "0.0-2268"]
                 [org.clojure/clojure "1.6.0"]]
  :plugins [[lein-cljsbuild "1.0.3"]]
  :min-lein-version "2.0.0"
  :cljsbuild
  {:builds [{:id "dev"
             :source-paths ["src"]
             :compiler {:output-to "app/sansatout.js"
                        :optimizations :whitespace
                        :pretty-print true}}]})
