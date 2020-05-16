package com.phoenix.phoenixliteracy

object BookletData {
    private val bookletTitles = arrayOf(
        "Booklet #1 - Dear God(s)",
        "Booklet #2 - Ray(y)a",
        "Booklet #3 - Mahasi(s)wa",
        "Booklet #4 - In-telek",
        "Booklet #5 - Just Go(d)",
        "Booklet #6 - Ka-Him part 1",
        "Booklet #7 - Spora-dis",
        "Booklet #8 - R.W.",
        "Booklet #9 - Jurnal Resimen",
        "Booklet #10 - Metamatika",
        "Booklet #11 - Dear God(s) 2",
        "Booklet #12 - Ka-him 2",
        "Booklet #13 - Statu(e)s",
        "Booklet #14 - Statu(e)s 2",
        "Booklet #15 - Te(kn)ologi",
        "Booklet #16 - Biografilm",
        "Booklet #17 - Diaspora",
        "Booklet #18 - Ka-him 3",
        "Booklet #19 - Pendidikan",
        "Booklet #20 - Semest(iny)a",
        "Booklet #21 - Literarsip",
        "Booklet #22 - Aktual",
        "Booklet #23 - Intel-ek",
        "Booklet #24 - e-fil-m",
        "Booklet #25 - Me-nerva",
        "Booklet #26 - Post-Literacy",
        "Booklet #27 - Sporasa",
        "Booklet #28 - Garis",
        "Booklet #29 - Kaffah",
        "Booklet #30 - Kaffah Bag. 2",
        "Booklet #31 - Kaffah Bag. 3",
        "Booklet #32 - Kaffah Bag. 4",
        "Booklet #33 - Statu(e)s 3",
        "Booklet #34 - (Con)science",
        "Booklet #35 - Metamatika II",
        "Booklet #36 - Mahkota"
    )

    private val bookletDescriptions = arrayOf(
        "Kumpulan monolog terhadap para dewa mengenai berbagai perenungan terhadap semesta",
        "Curhatan mengenai kehidupan bersama seorang teman imajiner",
        "Kumpulan opini mengenai kemahasiswaan ITB",
        "Kumpulan opini mengenai intelektualitas dan perguruan tinggi",
        "Kisah seorang pencari Tuhan",
        "Catatan pribadi seorang ketua himpunan bagian pertama",
        "Kumpulan puisi bertema lepas",
        "Review film untuk mengenang kematian Robin Williams",
        "Catatan-catatan kritik seorang anggota resimen mahasiswa",
        "Meninjau lebih jauh makna matematika",
        "Kumpulan monolog terhadap para dewa mengenai berbagai perenungan terhadap semesta (Lanjutan)",
        "Catatan pribadi seorang ketua himpunan bagian kedua",
        "Himpunan status-status Facebook tahun 2009-2012",
        "Himpunan status-status Facebook tahun 2012-2015",
        "Kumpulan opini mengenai teknologi",
        "Review film-film biografi",
        "Kumpulan puisi bertema lepas",
        "Catatan pribadi seorang ketua himpunan bagian terakhir",
        "Kumpulan opini mengenai pendidikan",
        "Kumpulan opini mengenai semesta, bumi, dan alam",
        "Kumpulan opini mengenai arsip dan literasi",
        "Kumpulan opini mengenai isu-isu aktual pada awal 2017",
        "Kumpulan opini mengenai intelektualitas dan perguruan tinggi (lagi)",
        "Review film campuran bertema umum kehidupan",
        "Kumpulan monolog self-critics dari seorang kawan kosmik",
        "Kumpulan opini mengenai fenomena baru literasi di era informasi",
        "Kumpulan puisi bertema lepas",
        "Arsip status-status dari akun pribadi LINE",
        "Kumpulan makalah mengenai pemikiran Islam",
        "Kumpulan makalah mengenai pemikiran Islam",
        "Kumpulan makalah mengenai pemikiran Islam",
        "Kumpulan makalah mengenai pemikiran Islam",
        "Himpunan status-status Facebook tahun 2015-2018",
        "Kumpulan opini mengenai sains, alam, dunia, dan manusia",
        "Meninjau lebih jauh makna matematika, bagian II",
        "Kumpulan tulisan di tengah pandemi Covid-19"
    )

    private val bookletCovers = intArrayOf(
        R.drawable.booklet1,
        R.drawable.booklet2,
        R.drawable.booklet3,
        R.drawable.booklet4,
        R.drawable.booklet5,
        R.drawable.booklet6,
        R.drawable.booklet7,
        R.drawable.booklet8,
        R.drawable.booklet9,
        R.drawable.booklet10,
        R.drawable.booklet11,
        R.drawable.booklet12,
        R.drawable.booklet13,
        R.drawable.booklet14,
        R.drawable.booklet15,
        R.drawable.booklet16,
        R.drawable.booklet17,
        R.drawable.booklet18,
        R.drawable.booklet19,
        R.drawable.booklet20,
        R.drawable.booklet21,
        R.drawable.booklet22,
        R.drawable.booklet23,
        R.drawable.booklet24,
        R.drawable.booklet25,
        R.drawable.booklet26,
        R.drawable.booklet27,
        R.drawable.booklet28,
        R.drawable.booklet29,
        R.drawable.booklet30,
        R.drawable.booklet31,
        R.drawable.booklet32,
        R.drawable.booklet33,
        R.drawable.booklet34,
        R.drawable.booklet35,
        R.drawable.booklet36
    )

    val listData: ArrayList<Booklet>
        get() {
            val list = arrayListOf<Booklet>()
            for (position in bookletTitles.indices) {
                val hero = Booklet()
                hero.title = bookletTitles[position]
                hero.detail = bookletDescriptions[position]
                hero.photo = bookletCovers[position]
                list.add(hero)
            }
            return list
        }
}