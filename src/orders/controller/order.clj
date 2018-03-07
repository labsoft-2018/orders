(ns orders.controller.order
  (:require [common-labsoft.protocols.datomic :as protocols.datomic]
            [orders.models.order :as models.order]
            [orders.db.datomic.order :as datomic.order]
            [schema.core :as s]))


(s/defn get-order-by-id :- models.order/Order
  [order-id :- s/Uuid, datomic :- protocols.datomic/IDatomic]
  (datomic.order/lookup! order-id datomic))
