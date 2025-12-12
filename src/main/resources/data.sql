INSERT INTO users (id, name, hashed_password, email, phone)
VALUES (1, 'Admin', 'hashed123', 'admin@example.com', '0123456789'),
       (2, 'Developer', 'hashed123', 'developer@example.com', '0123456987');

INSERT INTO categories (id, name, image_url)
VALUES (1, 'Bánh mì', 'https://cdn-media.hanoitimes.vn/2021/3/20/z2388286964567_365ff5742704671dadede255cf83f869.jpg'),
       (2, 'Bánh bao',
        'https://thumbs.dreamstime.com/b/banh-bao-isolated-white-background-delicious-steamed-bun-filled-savory-ingredients-363408595.jpg'),
       (3, 'Gà rán', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-191223210217-637127317379959333.jpg'),
       (4, 'Nước ngọt',
        'https://nutifood.com.vn/files/nutritionhouse/NUTIFOOD-SSQ/PRODUCT/PACKSHOT/2-PACKSHOTS/packshot-fruit-610x610px-eng.png'),
       (5, 'Mì trộn', 'https://nemluji.vn/wp-content/uploads/2025/02/Dia-mi-tron-thap-cam.jpg'),
       (6, 'Pizza', 'https://static.toiimg.com/thumb/56933159.cms?imgsize=686279&width=800&height=800'),
       (7, 'Bento',
        'https://thumbs.dreamstime.com/b/japanese-bento-box-asian-style-lunch-sushi-rolls-salad-fresh-sea-food-top-view-nori-maki-meat-cooked-vegetables-rice-329549683.jpg'),
       (8, 'Ăn vặt', 'https://nemnuonghungviet.com/nemhungviet/uploads/2024/11/an-vat-sai-gon-1.jpg');

INSERT INTO brands (id, name, image_url)
VALUES (1, 'Highland',
        'https://play-lh.googleusercontent.com/WthZu0rfWhv08r5CF24ideqmnAJiJ3oPn6-LEUObkLG82EB6lHHjWuGzVLQJ0NOVEtd9'),
       (2, 'Bánh mì Huỳnh Hoa', 'https://hestiafood.com.vn/wp-content/uploads/2022/10/Chat-voi-chung-toi-2.png'),
       (3, 'KFC',
        'https://play-lh.googleusercontent.com/O3geEaphALVx3jeI70oudMvyNTDTVVLLAd1jXFuI-oUv4bE7wQn4IPn2Y1cW8rgMElM'),
       (4, 'Jollibee',
        'https://play-lh.googleusercontent.com/W_DYClcNS6Jge8IZJIocA_fr6qkz7wbB_Xq92o8ACa-nYRl8ZzAiVenxqdPxu5aFb3Mb'),
       (5, 'Pizza Hut',
        'https://play-lh.googleusercontent.com/75zvOkV2CUS775itXQv8mDTUGn1Cl4Y7jxyx2Y91VajUBVeVP2BOTI83g9th8twuuw'),
       (6, 'McDonald''s', 'https://loop.com.vn/storage/logo-m-01.jpg');


INSERT INTO foods (id, image_url, name, name_no_accent, base_price, description, brand_id, category_id)
VALUES (1, 'https://media.loveitopcdn.com/24813/thumb/600x600/z4564243657819-f5b393659a568f6a0d4e329ac92bb3b4.jpg?zc=1',
        'Gà rán sốt cay', 'Ga ran sot cay', 59000.0,
        'Món gà rán cay ngon tuyệt vời, giòn rụm, đậm đà hương vị.', 3, 3),

       (2,
        'https://jollibee.com.vn/media/catalog/product/cache/11f3e6435b23ab624dc55c2d3fe9479d/g/_/g_s_t_cay_-_4-compressed.jpg',
        'Cơm gà sốt cay', 'Com ga sot cay', 65000.0,
        'Cơm gà sốt cay thơm ngon, đậm đà, phù hợp khẩu vị mọi người.', 4, 3),

       (3, 'https://cdn-media.hanoitimes.vn/2021/3/20/z2388286964567_365ff5742704671dadede255cf83f869.jpg',
        'Bánh mì thập cẩm', 'Banh mi thap cam', 29000.0,
        'Bánh mì thập cẩm với nhiều loại nhân hấp dẫn, ngon miệng.', 2, 1),

       (4,
        'https://pizzahut.vn/_next/image?url=https%3A%2F%2Fcdn.pizzahut.vn%2Fimages%2FWeb_V3%2FProducts_MenuTool%2FBulgogi._20251029134256KCW.webp&w=1024&q=100',
        'Pizza bò Hàn Quốc', 'Pizza bo Han Quoc', 120000.0,
        'Pizza bò Hàn Quốc với phô mai béo ngậy và thịt bò mềm mại.', 5, 6),

       (5,
        'https://pizzahut.vn/_next/image?url=https%3A%2F%2Fcdn.pizzahut.vn%2Fimages%2FWeb_V3%2FProducts_MenuTool%2FCheese%20Lover%20with%20honey._20250317172143IO1.webp&w=1170&q=75',
        'Pizza phô mai', 'Pizza pho mai', 110000.0,
        'Pizza phô mai thơm ngon, béo ngậy với lớp phô mai tan chảy hấp dẫn.', 5, 6),

       (6, 'https://noiphosaigon.vn/wp-content/uploads/2020/09/cach-lam-banh-bao-nhan-thit-thom-ngon.jpg',
        'Bánh bao thịt', 'Banh bao thit', 25000.0,
        'Bánh bao thịt nóng hổi, nhân thịt thơm ngon, mềm mịn.', 3, 7),

       (7, 'https://banhmihuynhhoa.vn/wp-content/uploads/2024/10/dscf0711-min-1-300x300.jpg',
        'Bánh mì Huỳnh Hoa', 'Banh mi Huynh Hoa', 40000.0,
        'Bánh mì Huỳnh Hoa đặc sản nổi tiếng, giòn tan, đậm đà hương vị.', 2, 1);