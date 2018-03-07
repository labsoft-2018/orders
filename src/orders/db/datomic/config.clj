(ns orders.db.datomic.config
  (:require [orders.models.order :as models.order]))


(def settings {:schemas [models.order/location-skeleton
                         models.order/order-skeleton]
               :enums   []})
