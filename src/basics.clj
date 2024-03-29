(ns basics)
(require '[clojure.repl :refer :all])

(prn (+ 1 2))
(prn (doc +))
(prn (doc doc))
(prn (apropos "+"))
(prn (find-doc "trim"))
(prn (dir clojure.repl))
(prn (source dir))
(def x 7)
(prn (+ x x))
(prn)
;Test your knowledge
(prn (+ 7654 1234))
(prn (/ (+ 5 (+ 7 (* 3 4))) 10))
(prn (doc rem))
(prn (doc mod))
(prn (find-doc "repl exception"))
