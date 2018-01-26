(ns orders.models.order
  (:require [schema.core :as s]
            [common-labsoft.time :as time]
            [common-labsoft.schema :as schema]))

(def location-skeleton {:location/lat {:schema s/Int :required true}
                        :location/lng {:schema s/Int :required true}})
(s/defschema Location (schema/skel->schema location-skeleton))

(def order-skeleton {:order/id          {:schema s/Uuid :id true}
                     :order/partner-id  {:schema s/Uuid :required false}
                     :order/customer-id {:schema s/Uuid :required true}
                     :order/created-at  {:schema time/LocalDateTime :required true}
                     :order/description {:schema s/Str :required true}
                     :order/destination {:schema location-skeleton :required true :component true}
                     :order/origin      {:schema location-skeleton :required true :component true}})
(s/defschema Order (schema/skel->schema order-skeleton))
