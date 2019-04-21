(ns functions)

(defn greet [name] (str "Hello, " name))
;Equivalent to anonymous function below
(def greet2 (fn [name] (str "Hello, " name)))

(defn messenger
  ([] (messenger "Hello world!"))
  ([msg] (println msg)))

(defn messenger2 [msg]
  (let [a 7
        b 5
        c (clojure.string/capitalize msg)]
    (println a b c)))

(defn hello [greeting & who]
  (println greeting who))

(defn message-builder [greeting]
  (fn [who] (println greeting who)))

(def hello-er (message-builder "Hello"))

;Invokes .length on obj
(fn [obj] (.length obj))

;Test Your Knowledge
(defn greet-knowledge-test [] (println "Hello"))
(def greet-knowledge-test2 (fn [] (println "Hello")))
(def greet-knowledge-test3 #(println "Hello"))

(defn greeting
  ([] (str "Hello, World!"))
  ([x] (str "Hello, " x "!"))
  ([x y] (str x ", " y "!")))

(defn do-nothing [x] (identity x))
(defn always-thing [& args] (keyword "thing"))
(defn make-thingy [x] (constantly x))

(defn triplicate [f]
  (apply f [])
  (apply f [])
  (apply f []))

(defn opposite [f]
  (fn [& args] (complement f)))

(defn triplicate2 [f & args]
  (triplicate (fn [] (apply f args))))

(defn pythagorean-identity [x]
  (+ (Math/pow (Math/sin x) 2) (Math/pow (Math/cos x) 2)))

(defn http-get [url]
  (slurp url))

(defn one-less-arg [f x]
  (fn [& args] (apply f x args)))

;end of Test Your Knowledge

(println "Examples")
(println (greet "students"))
(println (greet2 "students"))
(messenger)
(messenger "Hello class!")
(messenger2 "hello world")
(hello "Hello" "world" "class")
(hello-er "world!")

(println "Test Your Knowledge")
(greet-knowledge-test)
(greet-knowledge-test2)
(greet-knowledge-test3)
(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))
(println (do-nothing "Hi"))
(println (always-thing "Hi"))
(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f :foo)))
  (assert (= n (apply f :foo (range)))))
(triplicate greet-knowledge-test)
(println (opposite (boolean 0)))
(triplicate2 hello "Andy" "Andy")
(println (Math/cos (Math/PI)))
(println (pythagorean-identity 3))
(assert (.contains (http-get "http://www.w3.org") "html"))
((one-less-arg hello "andy") "andy")