package com.code.adesmart

object ProductsData {
    private val productNames= arrayOf(
        "Mie Goreng Aceh",
        "Mie Goreng Ayam Geprek",
        "Mie Cabe Hiau",
        "Mie Empal Gentong",
        "Mie Goreng Iga Penyet",
        "Mie Goreng Special",
        "Mie Goreng Rendang",
        "Mie Goreng Sate",
        "Mie Soto Original",
        "Mie Soto Lamongan",
        "Mie Soto Padang",
        "Mie Goreng Special Chicken"
    )
    private val productDetails= arrayOf(
        "Mie Goreng Kash Aceh",
        "Mie Goreng Rasa Ayam Geprek",
        "Mie Dengan sambal Cabe Hiau",
        "Mie Kash Cirebon rasa Empal Gentong",
        "Mie Goreng Rasa Iga Penyet",
        "Onde mande, Indomie Goreng Ayam Pop Baru #RasanyaPopMarkopop!\n" +
                "\n" +
                "Perpaduan mie goreng yang tebal dan kenyal dengan sambal Ayam Pop khas Sumatra Barat, aroma wangi daun salam, dan cabe merah kering asli, nikmatnya amboi nian",
        "Mie Goreng Rasa Rendang",
        "Mie Goreng Rasa Sate",
        "Mie Rasa Soto Original",
        "Mie RAsa Soto Lamongan",
        "Mie Rasa Soto Padang",
        "Mie Goreng Special Chicken Original"
    )
    
    private val productImages= intArrayOf(
        R.drawable.aceh,
        R.drawable.ayam_geprek,
        R.drawable.cabe_hijau,
        R.drawable.empal_gentong,
        R.drawable.iga_penyet,
        R.drawable.mie_goreng,
        R.drawable.rendang,
        R.drawable.sate,
        R.drawable.soto,
        R.drawable.soto_lamongan,
        R.drawable.soto_padang,
        R.drawable.specal_chicken,
    )
    
    val listData:ArrayList<Product>
    get(){
        val list = arrayListOf<Product>()
        for(position in productNames.indices){
            val product = Product()
            product.name = productNames[position]
            product.description = productDetails[position]
            product.photo = productImages[position]
            list.add(product)
        }
        return list
    }
}