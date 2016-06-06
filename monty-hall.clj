(defn monty-hall [] (
  let [
  doors [1 2 3]
  car-door (rand-nth doors)
  guess (rand-nth doors)
  shown-door (rand-nth
      (into [] (clojure.set/difference
        (set doors) (set [car-door guess]))))
  second-guess (first
    (into [] (clojure.set/difference
      (set doors) (set [shown-door guess]))))
 ]
  {:car-door car-door :guess guess :shown-door shown-door :second-guess second-guess}
))

(defn choose-first []
  (let [results (monty-hall)]
    (= (:guess results) (:car-door results))
  )
)

(defn choose-second []
  (let [results (monty-hall)]
    (= (:second-guess results) (:car-door results))
  )
)

(let [iterations 10000]
  (println (float (/
    (count (filter identity (repeatedly iterations choose-first)))
    iterations
  )))

  (println (float (/
    (count (filter identity (repeatedly iterations choose-second)))
    iterations
  )))
)
