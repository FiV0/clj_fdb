(ns me.vedang.clj-fdb.tuple.tuple
  (:refer-clojure :exclude [range])
  (:import com.apple.foundationdb.Range
           com.apple.foundationdb.tuple.Tuple
           java.lang.Object))

(defn from
  "Creates a new Tuple from a variable number of elements.

  Note: an empty number of arguments is a valid input to this
  function, it creates an empty Tuple."
  [& args]
  (try (Tuple/from (into-array args))
       (catch IllegalArgumentException _
         (Tuple/from (into-array Object args)))))


(defn from-bytes
  "Construct a new Tuple with elements decoded from a supplied byte array."
  [^"[B" ba]
  (Tuple/fromBytes ^"[B" ba))


(defn get-items
  "Gets the unserialized contents of this Tuple."
  [^Tuple t]
  (vec (.getItems t)))


(defn pack
  "Get an encoded representation of this Tuple."
  [^Tuple t]
  (.pack t))


(defn ^Range range
  "Returns a range representing all keys that encode Tuples strictly
  starting with this Tuple.

  For example:
      (range (from \"a\" \"b\"))
  includes all tuples (\"a\", \"b\", ...)

  Returns:
  the range of keys containing all Tuples that have this Tuple as a prefix."
  [^Tuple t]
  (.range t))
