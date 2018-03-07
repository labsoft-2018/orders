(ns orders.routes
  (:require [common-labsoft.pedestal.interceptors.auth :as int-auth]
            [common-labsoft.pedestal.interceptors.error :as int-err]
            [common-labsoft.pedestal.interceptors.adapt :as int-adapt]
            [common-labsoft.pedestal.interceptors.schema :as int-schema]
            [orders.controller.order :as controller.order]
            [io.pedestal.http.route.definition :refer [defroutes]]
            [io.pedestal.http :as http]
            [io.pedestal.http.body-params :as body-params]))

(defn order-by-id
  [{{:keys [datomic]} :components order-id :order-id}]
  {:status 200
   :body   (controller.order/get-order-by-id order-id datomic)})

(defroutes routes
           [[["/" ^:interceptors [int-err/catch!
                                  (body-params/body-params)
                                  int-adapt/coerce-body
                                  int-adapt/content-neg-intc
                                  int-auth/auth
                                  int-schema/coerce-output]
              ["/api"
               ["/orders/:id" ^:interceptors [(int-adapt/path->uuid :id :order-id)]
                {:get [:order-by-id order-by-id]}]]]]])
