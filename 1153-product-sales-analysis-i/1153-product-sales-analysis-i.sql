# Write your MySQL query statement below
SELECT p.product_name, s.year, s.price
from sales s, product p
where s.product_id = p.product_id