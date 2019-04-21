(ns collections)

;Vector
(def v [1 2 3])
;List
(def cards '(10 :ace :jack 9))
(def stack '(:a :b))

(println (get ["abc" false 99] 0))
(println (get ["abc" false 99] 1))
(println (get ["abc" false 99] 14))
(println (count [1 2 3]))
(println (vector 1 2 3))
(println (conj [1 2 3] 4 5 6))
(println v)
(println (conj v 4 5 6))
(println (first cards))
(println (rest cards))
(println (conj cards :queen))
(println (peek stack))
(println (pop stack))