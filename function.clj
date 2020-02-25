
(println "## Exercise 4")

(defn do-nothing [x] x)
(println (do-nothing "foo"))

(println "## Exercise 5")

(defn always-thing [x] 100)
(println (always-thing 50))

(println "## Exercise 6")
(defn make-thingy [x] (fn [& args] x))
(println ((make-thingy 6) 1 2 3 4))

(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f 123)))
  (assert (= n (apply f 123 (range)))))

(println "## Exercise 7")
(defn triplicate [f] (f) (f) (f))
(triplicate #(println "hello"))

(println "## Exercise 8")
(defn opposite [f]
  (fn [& args] (not (apply f args))))
(println (
  (opposite (fn [& args] (map #(+ 1))))
          1 2 3))

(println "## Exercise 9")
(defn triplicate2 [f & args]
  (triplicate (fn [] (apply f args))))
(println (triplicate2 (fn [x y] (println x y)) 1 2))

(println "## Exercise 10")
(println (Math/cos Math/PI))
(println (+ (Math/pow (Math/sin 0.3) 2) (Math/pow (Math/cos 0.3) 2)))

(println "## Exercise 11")
(defn http-get [url] (slurp url))
(assert (.contains (http-get "https://www.w3.org") "html"))

(println "## Exercise 12")
(defn one-less-arg [f x]
  (fn [& args] (apply f x args)))
(println ((one-less-arg + 2) 3))

(println "## Exercise 13")
(defn two-fns [f g]
  (fn [x] (f (g x))))
(println ((two-fns (partial + 1) (partial * 2)) 3))
