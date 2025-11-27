INSERT INTO users (id, name, hashed_password, email, phone)
VALUES
    (1, 'Admin', 'hashed123', 'admin@example.com', '0123456789'),
    (2, 'Developer', 'hashed123', 'developer@example.com', '0123456987');

INSERT INTO categories (id, name, image_url)
VALUES
   (1, 'Bánh mì', 'https://cdn-media.hanoitimes.vn/2021/3/20/z2388286964567_365ff5742704671dadede255cf83f869.jpg'),
   (2, 'Bánh bao', 'https://thumbs.dreamstime.com/b/banh-bao-isolated-white-background-delicious-steamed-bun-filled-savory-ingredients-363408595.jpg'),
   (3, 'Gà rán', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-191223210217-637127317379959333.jpg'),
   (4, 'Nước ngọt', 'https://nutifood.com.vn/files/nutritionhouse/NUTIFOOD-SSQ/PRODUCT/PACKSHOT/2-PACKSHOTS/packshot-fruit-610x610px-eng.png'),
   (5, 'Mì trộn', 'https://nemluji.vn/wp-content/uploads/2025/02/Dia-mi-tron-thap-cam.jpg'),
   (6, 'Pizza', 'https://static.toiimg.com/thumb/56933159.cms?imgsize=686279&width=800&height=800'),
   (7, 'Bento', 'https://thumbs.dreamstime.com/b/japanese-bento-box-asian-style-lunch-sushi-rolls-salad-fresh-sea-food-top-view-nori-maki-meat-cooked-vegetables-rice-329549683.jpg'),
   (8, 'Ăn vặt', 'https://nemnuonghungviet.com/nemhungviet/uploads/2024/11/an-vat-sai-gon-1.jpg');

INSERT INTO brands (id, name, image_url)
VALUES
    (1, 'Highland', 'https://play-lh.googleusercontent.com/WthZu0rfWhv08r5CF24ideqmnAJiJ3oPn6-LEUObkLG82EB6lHHjWuGzVLQJ0NOVEtd9'),
    (2, 'Bánh mì Huỳnh Hoa', 'https://hestiafood.com.vn/wp-content/uploads/2022/10/Chat-voi-chung-toi-2.png'),
    (3, 'KFC', 'https://play-lh.googleusercontent.com/O3geEaphALVx3jeI70oudMvyNTDTVVLLAd1jXFuI-oUv4bE7wQn4IPn2Y1cW8rgMElM'),
    (4, 'Jollibee', 'https://play-lh.googleusercontent.com/W_DYClcNS6Jge8IZJIocA_fr6qkz7wbB_Xq92o8ACa-nYRl8ZzAiVenxqdPxu5aFb3Mb'),
    (5, 'Pizza Hut', 'https://play-lh.googleusercontent.com/75zvOkV2CUS775itXQv8mDTUGn1Cl4Y7jxyx2Y91VajUBVeVP2BOTI83g9th8twuuw'),
    (6, 'McDonald''s', 'https://loop.com.vn/storage/logo-m-01.jpg');
