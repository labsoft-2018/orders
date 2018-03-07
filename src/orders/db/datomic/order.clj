(ns orders.db.datomic.order
  (:require [schema.core :as s]
            [orders.models.order :as models.order]
            [common-labsoft.protocols.datomic :as protocols.datomic]
            [common-labsoft.datomic.api :as datomic]))


(s/defn lookup! :- models.order/Order
  [order-id :- s/Uuid, datomic :- protocols.datomic/IDatomic]
  (datomic/lookup! :order/id order-id (datomic/db datomic)))
