(ns flowcontrol)

(defn when-example [x]
  (when (neg? x)
    (throw (RuntimeException. (str "x must be positive: " x)))))

(defn foo [x]
  (case x
    5 "x is 5"
    10 "x is 10"))

(defn foo2 [x]
  (case x
    5 "x is 5"
    10 "x is 10"
    "x isn't 5 or 10"))

(println (str "2 is " (if (even? 2) "even" "odd")))
(println (if (true? false) "impossible!"))
(if (even? 5)
  (do (println "even")
      true)
  (do (println "odd")
      false))
(when-example 2)
(println (let [x 5]
           (cond
             (< x 2) "x is less than 2"
             (< x 10) "x is less than 10")))
(println (let [x 11]
           (cond
             (< x 2) "x is less than 2"
             (< x 10) "x is less than 10"
             :else "x is greater than or equal to 10")))
(println (foo 10))
(println (foo2 11))
(dotimes [i 3]
  (println i))
(doseq [n (range 3)]
  (println n))
(doseq [letter [:a :b]
        number (range 3)]
  (prn [letter number]))
(println (for [letter [:a :b]
               number (range 3)]
           [letter number]))
(loop [i 0]
  (if (< i 10)
    (recur (inc i))
    (println i)))
(try
  (/ 2 1)
  (catch ArithmeticException e
    "divide by 0")
  (finally
    (println "cleanup")))
(try
  (throw (Exception. "something went wrong"))
  (catch Exception e (println (.getMessage e))))
(try
  (throw (ex-info "There was a problem" {:detail 42}))
  (catch Exception e
    (prn (:detail (ex-data e)))))