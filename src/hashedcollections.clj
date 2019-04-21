(ns hashedcollections)

;Set
(def players #{"Alice", "Bob", "Kelly"})
;Map
(def scores {"Fred" 1400, "Bob" 1240, "Angela" 1024})
(def new-scores {"Angela" 300 "Jeff" 900})
(def directions {:north 0
                 :east 1
                 :south 2
                 :west 3})
(def sm (sorted-map
          "Bravo" 204
          "Alfa" 35
          "Sigma" 99
          "Charlie" 100))
(def person
  {:first-name "Kelly"
   :last-name "Keen"
   :age 32
   :occupation "Programmer"})
(def company
  {:name "WidgetCo"
   :address {:street "123 Main St"
             :city "Springfield"
             :state "IL"}})

(defrecord PersonStructure [first-name last-name age occupation])

(def kelly (->PersonStructure "Kelly" "Keen" 32 "Programmer"))
(def kelly2 (map->PersonStructure
              {:first-name "Kelly"
               :last-name "Keen"
               :age 32
               :occupation "Programmer"}))

(def new-players ["Tim" "Sue" "Greg"])

(println (conj players "Fred"))
(println (disj players "Bob" "Sal"))
(println (contains? players "Kelly"))
(println (conj (sorted-set) "Bravo" "Charlie" "Sigma" "Alpha"))
(println (into players new-players))
(println (assoc scores "Sally" 0))
(println (assoc scores "Bob" 0))
(println (dissoc scores "Bob"))
(println (get scores "Angela"))
(println (directions :north))
(println (get scores "Sam" 0))
(println (directions :northwest -1))
(println (contains? scores "Fred"))
(println (find scores "Fred"))
(println (keys scores))
(println (vals scores))
(println (zipmap players (repeat 0)))
(println (into {} (map (fn [player] [player 0]) players)))
(println (reduce (fn [m player]
                   (assoc m player 0))
                 {}
                 players))
(println (merge scores new-scores))
(println sm)
(println (get person :occupation))
(println (:occupation person))
(println (assoc person :occupation "Baker"))
(println (dissoc person :age))
(println (get-in company [:address :city]))
(println (assoc-in company [:address :street] "303 Broadway"))
(println kelly)
(println kelly2)