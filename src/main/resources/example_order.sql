-- 1. Insert Payment Gateway (để lấy ID)
INSERT INTO "PAYMENT_GATEWAYS" ("ID", "NAME", "TRANSACTION_ID", "REDIRECT_URL", "EXTRA_DATA")
VALUES (1, 'momo', NULL, 'https://test-payment.momo.vn/v2/gateway/pay?t=TU9NT1Q1QloyMDIzMTIxM19URVNUfFBhcnRuZXJfVHJhbnNhY3Rpb25fSURfMTcyMTcyMDYyMDA3OA&s=6c14385cd4355e0abe0e0563a2da20705bceca9fac79746b2bf6a4c380374b44', NULL);

-- 2. Insert Address
INSERT INTO "ADDRESSES" ("ADDRESS_ID", "LATITUDE", "LONGITUDE", "LOCATION", "NAME", "PHONE", "SNAPSHOT", "USER_ID")
VALUES ('123', 10.871355874268529, 106.79179776930363, 'VQCR+GP6, khu phố 6, Thủ Đức, Thành phố Hồ Chí Minh, Việt Nam', 'Trường Đại học Nông Lâm TP. Hồ Chí Minh', '012345678', TRUE, 1);

-- 3. Insert Payment
INSERT INTO "PAYMENTS" ("ID", "PAYMENT_METHOD", "PAYMENT_STATUS", "GATEWAY_ID")
VALUES (1, 'momo', 'awaiting_payment', 1);

-- 4. Insert Order
INSERT INTO "ORDERS" ("ID", "CODE", "CREATED_AT", "AMOUNT", "DISCOUNT", "SHIPPING_FEE", "TOTAL", "STATUS", "USER_ID", "VOUCHER_CODE", "ADDRESS_ID", "PAYMENT_ID")
VALUES (1, 'O20250110123456', '2025-01-10 15:20:00+00', 110000, 10000, 22000, 131000, 'pending', NULL, 'FREESHIP12122025', '123', 1);

-- 5. Insert Order Item
INSERT INTO "ORDER_ITEMS" ("ID", "AMOUNT", "OPTION_COST", "QUANTITY", "SUBTOTAL", "FOOD_ID", "ORDER_ID")
VALUES (1, 49000, 6000, 2, 110000, 3, 1);

-- 6. Insert Food Options (phải có trước Food Option Values)
INSERT INTO "FOOD_OPTIONS" ("ID", "NAME", "FOOD_ID") VALUES
                                                         ('111', 'Lựa chọn ớt', 3),
                                                         ('222', 'Lựa chọn patê', 3),
                                                         ('333', 'Lựa chọn topping', 3);

-- 7. Insert Food Option Values (2 lựa chọn cho mỗi Food Option)
INSERT INTO "FOOD_OPTION_VALUES" ("ID", "COST", "OPTION_VALUE", "OPTION_ID") VALUES
                                                                                 ('111-1', 0, 'Không ớt', '111'),
                                                                                 ('111-2', 0, 'Có ớt', '111'),
                                                                                 ('222-1', 0, 'Ít patê', '222'),
                                                                                 ('222-2', 3000, 'Nhiều patê', '222'),
                                                                                 ('333-1', 6000, '2 trứng', '333'),
                                                                                 ('333-2', 10000, '3 trứng', '333');

-- 8. Insert Item Options (tham chiếu đúng Food Option Values)
INSERT INTO "ITEM_OPTIONS" ("ID", "COST", "NAME", "OPTION_VALUE", "SNAPSHOT", "FOOD_OPTION_VALUE_ID", "ORDER_ITEM_ID") VALUES
                                                                                                                           (1, 0, 'Lựa chọn ớt', 'Không ớt', TRUE, '111-1', 1),
                                                                                                                           (2, 0, 'Lựa chọn patê', 'Ít patê', TRUE, '222-1', 1),
                                                                                                                           (3, 6000, 'Lựa chọn topping', '2 trứng', TRUE, '333-1', 1);
