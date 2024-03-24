# Write your MySQL query statement below
with first_orders as (
    select customer_id, min(order_date) as firstOrderDate from Delivery group by customer_id
),

immediate_first_orders as (
    select first_orders.customer_id from first_orders JOIN Delivery
    on first_orders.customer_id = Delivery.customer_id and
    first_orders.firstOrderDate = Delivery.order_date
    where Delivery.order_date = Delivery.customer_pref_delivery_date
)

select round( count(*) * 100 / (select count(*) from first_orders), 2) as immediate_percentage from immediate_first_orders;