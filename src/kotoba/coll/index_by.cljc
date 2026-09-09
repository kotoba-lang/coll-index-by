(ns kotoba.coll.index-by
  "index-by -- one definition, addressed on its own.

  Split out of kotoba.lang.text on 2026-09-09. The unit here is the
  DEFINITION, not the library: this repo holds index-by and names, in its
  deps.edn, exactly the definitions index-by reaches. Nothing else."
  )

(defn index-by
  "Return a map from `(keyfn item)` to `item` for each `item` in `coll`. Later
  items win on key collision. Nil keys are dropped (a nil key would collapse
  entries)."
  [keyfn coll]
  (reduce (fn [out item]
            (let [k (keyfn item)]
              (if (nil? k) out (assoc out k item))))
          {} coll))
