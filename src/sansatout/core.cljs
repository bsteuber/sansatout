(ns sansatout.core
  (:require [clojure.string :as str]
            [goog.dom :as gdom]))

(defn render [id x]
  (gdom/setTextContent
   (gdom/$ id)
   (str x)))

(def suit->str
  (partial get "♠♥♦♣"))

(def val->str
  (partial get "23456789ZBDKA"))

(def deck
  (for [suit (range 4)
        val (range 13)]
    [suit val]))

(defn deal []
  (->> deck
       shuffle
       (partition 13)))

(defn format-suit [cards]
  (let [suit-str (suit->str (ffirst cards))]
    (->> cards
         (map (comp val->str second))
         (str/join)
         (str suit-str))))

(defn format-hand [hand]
  (->> hand
       sort
       (partition-by first)
       (map format-suit)
       (str/join " ")))

(defn main []
  (let [[w n o s] (map format-hand (deal))]
    (render "west" w)
    (render "nord" n)
    (render "ost" o)
    (render "sued" s)))
