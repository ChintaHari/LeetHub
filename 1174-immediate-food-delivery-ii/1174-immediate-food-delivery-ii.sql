# Write your MySQL query statement below

#Step 1: Find all the customer's first orders.
#Step 2: From the result obtained from step 1, filter those records whose order date = preferred delivery date
#(Hint for step 2: Use join)
#Step 3: Now calculate the percentage of step1 with step 2

with first_orders as(
    select customer_id, min(order_date) as firstOrderDate from Delivery group by customer_id
),

immediate_first_orders as(
    select first_orders.customer_id from first_orders 
    JOIN Delivery ON 
    first_orders.customer_id = Delivery.customer_id 
    and   
    first_orders.firstOrderDate = Delivery.order_date
    where Delivery.order_date = Delivery.customer_pref_delivery_date
)

select round((count(*) * 100) / (select count(*) from first_orders), 2) as immediate_percentage from immediate_first_orders

