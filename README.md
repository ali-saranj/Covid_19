<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>تیم تبلیغاتی شما</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            font-family: 'Tahoma', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f8f8;
            color: #333;
        }

        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 2em;
        }

        section {
            padding: 40px;
            text-align: center;
        }

        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 2em;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        /* افزودن سایه به بخش‌ها */
        section, footer {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* استفاده از تصویر پس‌زمینه در header */
        header {
            background-image: url('background.jpg');
            background-size: cover;
            background-position: center;
        }

        /* استفاده از انیمیشن برای ظاهر شدن محتوا */
        section, footer {
            opacity: 0;
            animation: fadeIn 1s forwards;
        }

        @keyframes fadeIn {
            to {
                opacity: 1;
            }
        }

        /* استفاده از رنگ‌های دلخواه */
        h1, h2, p {
            color: #2c3e50;
        }

        /* استفاده از رنگ دلخواه برای آیکون‌ها */
        .fas {
            color: #3498db;
        }

        /* استایل نمونه کارها */
        .portfolio {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            margin-top: 30px;
        }

        .portfolio-item {
            position: relative;
            overflow: hidden;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease-in-out;
        }

        .portfolio-item img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }

        .portfolio-item:hover {
            transform: scale(1.05);
        }

        /* استایل عنوان نمونه کارها */
        h3.portfolio-title {
            margin: 10px 0;
            color: #333;
        }
    </style>
</head>
<body>

<header>
    <h1>تیم تبلیغاتی شما</h1>
</header>

<section>
    <h2>خدمات ما</h2>
    <p>
        <i class="fas fa-bullhorn fa-3x"></i><br>
        تبلیغات اثربخش و حرفه‌ای
    </p>
    <p>
        <i class="fas fa-chart-bar fa-3x"></i><br>
        تحلیل و بهینه‌سازی کمپین‌ها
    </p>
    <p>
        <i class="fas fa-paint-brush fa-3x"></i><br>
        طراحی خلاقانه و جذاب
    </p>
</section>

<section>
    <h2>نمونه کارها</h2>
    <div class="portfolio">
        <div class="portfolio-item">
            <img src="portfolio1.jpg" alt="نمونه کار 1">
            <h3 class="portfolio-title">کمپین تبلیغاتی X</h3>
        </div>
        <div class="portfolio-item">
            <img src="portfolio2.jpg" alt="نمونه کار 2">
            <h3 class="portfolio-title">طراحی بنر‌های خلاقانه</h3>
        </div>
        <!-- دیگر نمونه کارها -->
    </div>
</section>

<footer>
    <p>تمامی حقوق محفوظ است - تیم تبلیغاتی شما</p>
</footer>

</body>
</html>


