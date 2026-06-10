package com.example.final_lab_mobile.network;

import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MockInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        String json = "{\n" +
                "  \"products\": [\n" +
                "    { \"id\": 1, \"title\": \"Tenda Dome Kapasitas 2 Orang\", \"description\": \"Tenda double layer anti air dengan sirkulasi udara yang baik. Cocok untuk pendakian gunung beriklim tropis.\", \"price\": 45.99, \"rating\": 4.8, \"thumbnail\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwPhYM8jLvjXJE_i_RzN0pDY-C7SUfueIgVA&s\" },\n" +
                "    { \"id\": 2, \"title\": \"Tenda Family Kapasitas 6 Orang\", \"description\": \"Tenda berukuran luas untuk keluarga dengan ruang tamu terpisah dan material tahan angin kencang.\", \"price\": 120.00, \"rating\": 4.6, \"thumbnail\": \"https://image.made-in-china.com/202f0j00VCBbqPIhlkcF/Family-Outdoor-Portable-Sunshade-Camping-Picnic-Tent-for-6-Persons.webp\" },\n" +
                "    { \"id\": 3, \"title\": \"Carrier Bag 45L\", \"description\": \"Tas gunung kapasitas menengah dengan backsystem nyaman untuk pendakian 1-2 hari.\", \"price\": 55.50, \"rating\": 4.7, \"thumbnail\": \"https://id-live-01.slatic.net/p/9140f21950fee27ad5e290cda6e805e1.jpg\" },\n" +
                "    { \"id\": 4, \"title\": \"Carrier Bag 60L + Raincover\", \"description\": \"Ransel ekspedisi dengan kompartemen luas, jahitan kuat, dan sudah termasuk jas hujan tas.\", \"price\": 75.00, \"rating\": 4.9, \"thumbnail\": \"https://www.eigeradventure.com/blog/wp-content/uploads/2025/10/R.-Wanderlust-60L-1.jpg\" },\n" +
                "    { \"id\": 5, \"title\": \"Daypack Lipat 20L\", \"description\": \"Tas kecil yang bisa dilipat menjadi seukuran kepalan tangan. Sangat ringan untuk summit attack.\", \"price\": 15.99, \"rating\": 4.5, \"thumbnail\": \"https://down-id.img.susercontent.com/file/id-11134207-7rasg-m4lagutjkjuc45\" },\n" +
                "    { \"id\": 6, \"title\": \"Sleeping Bag Model Mummy\", \"description\": \"Kantong tidur dengan isolasi thermal tinggi. Mampu menahan suhu hingga 5 derajat celcius.\", \"price\": 35.00, \"rating\": 4.8, \"thumbnail\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZWXVy5v_KcNxfMesPzo8N5sL_x4lOn8hjug&s\" },\n" +
                "    { \"id\": 7, \"title\": \"Sleeping Bag Tikar / Envelope\", \"description\": \"Kantong tidur bentuk persegi yang bisa dibuka penuh menjadi selimut. Nyaman untuk camping ceria.\", \"price\": 25.50, \"rating\": 4.4, \"thumbnail\": \"https://www.indonesiatrekkingcamping.com/wp-content/uploads/2023/03/Sleeping_Bag_harga_sewa_10.0001.jpg\" },\n" +
                "    { \"id\": 8, \"title\": \"Matras Aluminium Foil\", \"description\": \"Alas tidur penahan dingin dari tanah dengan lapisan foil reflektif.\", \"price\": 8.00, \"rating\": 4.6, \"thumbnail\": \"https://antarestar.com/wp-content/uploads/2024/09/Desain-tanpa-judul-7.png\" },\n" +
                "    { \"id\": 9, \"title\": \"Sleeping Pad Angin Ultralight\", \"description\": \"Matras angin yang sangat empuk dan tebal, namun bisa dilipat sangat kecil saat tidak digunakan.\", \"price\": 42.00, \"rating\": 4.9, \"thumbnail\": \"https://upload.jaknot.com/2025/05/images/products/414246/original/naturebell-kasur-matras-angin-rhombus-design-for-sleeping-bag-nh19.jpg\" },\n" +
                "    { \"id\": 10, \"title\": \"Sepatu Hiking Pria Waterproof\", \"description\": \"Sepatu gunung dengan grip outsole kuat dan membran tahan air untuk segala medan.\", \"price\": 65.00, \"rating\": 4.8, \"thumbnail\": \"https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//catalog-image/100/MTA-117790317/snta_sepatu_gunung-hiking_outdoor_snta_505_grey_ltblue_boots_trekking_climbing_mendaki_gunung_gratis_ongkir_terbaru_stok_terbatas_sports_climbing_shoes_full01_dchc1tuf.jpg\" },\n" +
                "    { \"id\": 11, \"title\": \"Sepatu Trekking Wanita Mid-Cut\", \"description\": \"Sepatu hiking desain khusus wanita, melindungi engkel dengan bantalan insole yang empuk.\", \"price\": 62.50, \"rating\": 4.7, \"thumbnail\": \"https://down-id.img.susercontent.com/file/id-11134207-7r98o-lubgjzaq39au6d\" },\n" +
                "    { \"id\": 12, \"title\": \"Sandal Gunung Tali Kuat\", \"description\": \"Sandal tangguh untuk bersantai di area camp atau trekking ringan melintasi sungai.\", \"price\": 20.00, \"rating\": 4.5, \"thumbnail\": \"https://antarestar.com/wp-content/uploads/2024/04/SENDAL-ARCHER-BARU-FOTO-MALL-5.webp\" },\n" +
                "    { \"id\": 13, \"title\": \"Trekking Pole Aluminium\", \"description\": \"Tongkat daki tiga tingkat berbahan duralumin yang kuat menopang beban tubuh.\", \"price\": 18.50, \"rating\": 4.6, \"thumbnail\": \"https://down-id.img.susercontent.com/file/sg-11134201-81zua-mmsrk1ov2y2ta7\" },\n" +
                "    { \"id\": 14, \"title\": \"Trekking Pole Carbon Ultralight\", \"description\": \"Tongkat trekking berbahan serat karbon. Super ringan namun memiliki daya lentur yang aman.\", \"price\": 38.00, \"rating\": 4.9, \"thumbnail\": \"https://cdn11.bigcommerce.com/s-98f3d/images/stencil/1280x1280/products/1778/32637/Leki_Legacy_Lite_AS_Trekking_Poles__24495.1711917643.jpg?c=2\" },\n" +
                "    { \"id\": 15, \"title\": \"Kompor Portable Mawar Lipat\", \"description\": \"Kompor camping klasik dengan selang gas. Stabil untuk memasak dengan panci besar.\", \"price\": 14.99, \"rating\": 4.7, \"thumbnail\": \"https://p16-oec-sg.ibyteimg.com/tos-alisg-i-aphluv4xwc-sg/img/VqbcmM/2022/6/17/da18374e-6806-45bc-9b9c-8be66e3dbf8a.jpg~tplv-aphluv4xwc-resize-jpeg:700:0.jpg\" },\n" +
                "    { \"id\": 16, \"title\": \"Kompor Gas Ultralight Mini\", \"description\": \"Kompor saku berbahan titanium murni. Hanya seberat 45 gram namun apinya sangat besar.\", \"price\": 22.00, \"rating\": 4.8, \"thumbnail\": \"https://down-id.img.susercontent.com/file/e3a4b0a97cf41834b945e85a6c2345a8\" },\n" +
                "    { \"id\": 17, \"title\": \"Gas Kaleng Lindal Valve 230g\", \"description\": \"Bahan bakar gas propana-butana khusus outdoor yang tetap menyala di suhu dingin.\", \"price\": 5.50, \"rating\": 4.9, \"thumbnail\": \"https://image.astronauts.cloud/product-images/2024/1/BrightGasKaleng220gram_20286be6-2ad6-4979-88a2-a37d872d869e_900x900.png\" },\n" +
                "    { \"id\": 18, \"title\": \"Cooking Set / Nesting Susun 4\", \"description\": \"Panci dan wajan aluminium anti lengket yang bisa disusun rapi menjadi satu tabung.\", \"price\": 28.99, \"rating\": 4.6, \"thumbnail\": \"https://down-id.img.susercontent.com/file/d5b74ad8a7bf5ec9f0dcafb41114af28\" },\n" +
                "    { \"id\": 19, \"title\": \"Panci Tunggal Titanium 750ml\", \"description\": \"Panci ultra ringan yang bisa sekaligus dijadikan mug. Dilengkapi gagang lipat.\", \"price\": 34.00, \"rating\": 4.9, \"thumbnail\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwcV7aM1V3nPh3SSTTYlwp5I566ftctIvOvA&s\" },\n" +
                "    { \"id\": 20, \"title\": \"Mug Cangkir Stainless Steel\", \"description\": \"Cangkir anti pecah dengan carabiner sebagai gagangnya. Praktis digantung di tas.\", \"price\": 6.50, \"rating\": 4.5, \"thumbnail\": \"https://down-id.img.susercontent.com/file/sg-11134201-22100-yhdl8yygybjv2b\" },\n" +
                "    { \"id\": 21, \"title\": \"Spork Lipat (Sendok Garpu)\", \"description\": \"Alat makan praktis kombinasi sendok dan garpu yang bisa dilipat dua.\", \"price\": 4.99, \"rating\": 4.4, \"thumbnail\": \"https://down-id.img.susercontent.com/file/sg-11134201-23010-3qjtmji9sqmv48\" },\n" +
                "    { \"id\": 22, \"title\": \"Pisau Lipat Survival Multifungsi\", \"description\": \"Dilengkapi pisau utama, pembuka kaleng, gergaji kayu kecil, and gunting.\", \"price\": 19.99, \"rating\": 4.8, \"thumbnail\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRncPQDtehoWOH30LfK2rbwb6ovEE8DAe4U1Q&s\" },\n" +
                "    { \"id\": 23, \"title\": \"Headlamp LED 300 Lumens\", \"description\": \"Senter kepala dengan sensor gerak dan fitur cahaya merah untuk menjaga rabun malam.\", \"price\": 24.50, \"rating\": 4.7, \"thumbnail\": \"https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//1006/mountlines_headlamp-camping-senter-kepala-pendaki_full02.jpg\" },\n" +
                "    { \"id\": 24, \"title\": \"Senter Taktikal Jarak Jauh\", \"description\": \"Senter genggam bahan metal dengan fitur zoom in/out dan strobo untuk SOS.\", \"price\": 16.00, \"rating\": 4.6, \"thumbnail\": \"https://cdn.ruparupa.io/fit-in/400x400/filters:format(webp)/filters:quality(90)/ruparupa-com/image/upload/Products/10155901_1.jpg\" },\n" +
                "    { \"id\": 25, \"title\": \"Lampu Tenda Gantung LED\", \"description\": \"Lampu penerangan ruang tenda yang cahayanya menyebar merata tanpa menyilaukan mata.\", \"price\": 10.50, \"rating\": 4.5, \"thumbnail\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOT_3TuF4d6qvt7qHTfWrQhS4ano1SEM_4DA&s\" },\n" +
                "    { \"id\": 26, \"title\": \"Jaket Gunung Windproof & Waterproof\", \"description\": \"Jaket dengan teknologi membran gore-tex. Melindungi tubuh dari angin and hujan lebat.\", \"price\": 85.00, \"rating\": 4.9, \"thumbnail\": \"https://down-id.img.susercontent.com/file/id-11134207-7ras8-m2ugv2y1m2r640\" },\n" +
                "    { \"id\": 27, \"title\": \"Jaket Polar Fleece Penghangat\", \"description\": \"Lapisan tengah (mid-layer) berbahan bulu sintetis tebal untuk menahan suhu beku di gunung.\", \"price\": 35.00, \"rating\": 4.8, \"thumbnail\": \"https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//catalog-image/105/MTA-123396657/brd-44261_jaket-hiking-musim-dingin-pria-waterproof-polar-soft-shell-winter-jacket_full02-b51d85b0.jpg\" },\n" +
                "    { \"id\": 28, \"title\": \"Jas Hujan Ponco Serbaguna\", \"description\": \"Mantel hujan model kelelawar. Bisa dibuka lebarkan menjadi flysheet darurat.\", \"price\": 18.00, \"rating\": 4.4, \"thumbnail\": \"https://p16-oec-sg.ibyteimg.com/tos-alisg-i-aphluv4xwc-sg/img/VqbcmM/2021/12/24/c67f85dd-3616-42bf-ad44-a8bab838cae7.jpg~tplv-aphluv4xwc-resize-jpeg:700:0.jpg\" },\n" +
                "    { \"id\": 29, \"title\": \"Celana Gunung Quick Dry\", \"description\": \"Celana trekking ringan yang sangat cepat kering jika terkena air atau keringat.\", \"price\": 25.00, \"rating\": 4.7, \"thumbnail\": \"https://down-id.img.susercontent.com/file/id-11134207-7rbke-m7jcqaxxpbl821\" },\n" +
                "    { \"id\": 30, \"title\": \"Kaos Kaki Trekking Tebal\", \"description\": \"Kaos kaki wool campuran yang empuk, hangat, and mencegah kaki lecet saat mendaki.\", \"price\": 8.50, \"rating\": 4.9, \"thumbnail\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHbDtlGnwkBUJ7B3usruZcy_SluMcqdvDLrQ&s\" }\n" +
                "  ]\n" +
                "}";

        return new Response.Builder()
                .code(200)
                .message("OK")
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .body(ResponseBody.create(MediaType.parse("application/json"), json.getBytes()))
                .addHeader("content-type", "application/json")
                .build();
    }
}
