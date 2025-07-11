<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Cards</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 40px;
        }

        .container {
            display: flex;
            justify-content: center;
            gap: 30px;
            flex-wrap: wrap;
        }

        .card {
            background: white;
            width: 220px;
            border-radius: 16px;
            box-shadow: 0 6px 12px rgba(0,0,0,0.1);
            text-align: center;
            padding: 20px 15px;
            transition: transform 0.2s;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card img {
            height: 100px;
            object-fit: contain;
            margin-bottom: 10px;
        }

        .card h3 {
            margin: 0;
            font-size: 1.2rem;
            font-weight: bold;
        }

        .card p {
            font-size: 0.85rem;
            color: #777;
            margin: 8px 0;
        }

        .card h4 {
            font-size: 1rem;
            color: #222;
            margin: 10px 0 5px;
        }

        .stars {
            color: #f6b01e;
            margin-bottom: 10px;
        }

        .btn {
            width: 100%;
            padding: 10px;
            border: none;
            font-weight: bold;
            color: white;
            border-radius: 6px;
            cursor: pointer;
        }

        .blue { background-color: #00bcd4; }
        .indigo { background-color: #3f51b5; }
        .black { background-color: #333; }
        .orange { background-color: #ff9800; }
    </style>
</head>
<body>

<div class="container">
    <div class="card">
        <img src="https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSKj-g_4Saw-TJgiGp66J917My0iVwSmQirVBd67u98bmvrrPHXJsT7ukvnglaqdRJ1uK1Ehp2FnfTLHDdUu5-6y_Dn6iJdiSZ8Le6ywcyAqCizGnCsdYRbjkAn" alt="Shoes">
        <h3>Shoes</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        <h4>$100.00</h4>
        <div class="stars">★ ★ ★ ★ ☆</div>
        <button class="btn blue">Buy Now</button>
    </div>

    <div class="card">
        <img src="https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSk2QwrGLKQLw27UJH0fuXnTEkhENIkKI87zGio2k0QnKfiok-5z60LV44K32WOD2ZMVQ6X7kBOU1l-vtNKEyi4mzLIUol4uvQbv1UspCgXmgHOPSrjnuWzaA" alt="Earphone">
        <h3>Earphone</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        <h4>$40.00</h4>
        <div class="stars">★ ★ ★ ★ ☆</div>
        <button class="btn indigo">Buy Now</button>
    </div>

    <div class="card">
        <img src="https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcRP1alFk0ewQ_DcMDH2GT_JIf1Z3-jZhTssmDhbFriqH4d-TF_XX05YZgh-nOF4O3IZ0Dd6RUT1_i6d0zFzQALj2CTcuLa8W0y9A3ftWgzNuE8J7XCcaawU" alt="Watch">
        <h3>Watch</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        <h4>$70.84</h4>
        <div class="stars">★ ★ ★ ★ ☆</div>
        <button class="btn black">Buy Now</button>
    </div>

    <div class="card">
        <img src="https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcQmGWN-iyIvYvOzPLBynP2xfmrSsNl0Gn35v-vk2NJrVET0mQpGqyjDmcxUyW568CvctxuJyW248KHwzpI2JhwPnxwurH9zRM5wrlT85Fvhuq_8Sq8lslxzYA" alt="Mobile">
        <h3>Mobile</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        <h4>$1000.84</h4>
        <div class="stars">★ ★ ★ ★ ★</div>
        <button class="btn orange">Buy Now</button>
    </div>
</div>

</body>
</html>
