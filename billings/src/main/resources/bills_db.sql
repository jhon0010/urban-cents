INSERT INTO bills (user_id, user_email, amount, billing_date, due_date, status) VALUES
(1, 'user1@example.com', 100.00, '2024-01-01', '2024-02-01', 'PENDING'),
(2, 'user2@example.com', 150.50, '2024-01-15', '2024-02-15', 'PENDING'),
(3, 'user3@example.com', 200.00, '2024-02-01', '2024-03-01', 'PENDING'),
(4, 'user4@example.com', 250.75, '2024-02-15', '2024-03-15', 'PENDING'),
(5, 'user5@example.com', 300.00, '2024-03-01', '2024-04-01', 'PENDING'),
(6, 'user6@example.com', 350.25, '2024-03-15', '2024-04-15', 'PENDING'),
(7, 'user7@example.com', 400.00, '2024-04-01', '2024-05-01', 'PENDING'),
(8, 'user8@example.com', 450.50, '2024-04-15', '2024-05-15', 'PENDING'),
(9, 'user9@example.com', 500.00, '2024-05-01', '2024-06-01', 'PENDING'),
(10, 'user10@example.com', 550.75, '2024-05-15', '2024-06-15', 'PENDING');

INSERT INTO bill_adjustments (bill_id, adjustment_amount, reason) VALUES
(1, -10.00, 'DISCOUNT'),
(2, -15.50, 'DISCOUNT'),
(3, -20.00, 'DISCOUNT'),
(4, 25.75, 'LATE_FEE'),
(5, -30.00, 'DISCOUNT'),
(6, 35.25, 'LATE_FEE'),
(7, -40.00, 'DISCOUNT'),
(8, 45.50, 'LATE_FEE'),
(9, -50.00, 'DISCOUNT'),
(10, 55.75, 'LATE_FEE');
