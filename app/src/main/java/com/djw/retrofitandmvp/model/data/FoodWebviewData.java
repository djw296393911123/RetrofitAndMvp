package com.djw.retrofitandmvp.model.data;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class FoodWebviewData {

    /**
     * count : 4513
     * description : 茄子是很吸油的，所以炒的时候锅内只需放很少的油甚至不放油，然后将茄子里渗出来的油到进锅内，待锅烧到5成热的时候，到入四川辣豆酱翻炒，待到油变红，豆瓣酱水份快收干的时候放入切好的蒜，姜沫，香味出来后，倒入碎猪肉，炒熟后倒入甜辣椒酱，翻炒后倒入炸好的茄子，盐，炒匀后加入少许清水
     * fcount : 0
     * food : 茄子,辣豆瓣酱,甜辣椒酱,味精,猪碎肉,水淀粉
     * id : 1
     * images :
     * img : /cook/150802/c6edcd023d16c055f0c90098789caad8.jpg
     * keywords : 茄子 辣椒酱 时候 豆瓣酱 然后
     * message : <h2>材料 </h2><hr>
     <p>茄子，葱4根，四川辣豆瓣酱，甜辣椒酱，盐，味精，蒜一头，姜(用量稍少于蒜)，猪碎肉，水淀粉</p>   <h2>做法 </h2><hr>
     <p>1.将茄子从上至下剖成两半， 然后用刀把茄子表面切成鱼鳞状， 注意不要把茄子切断了. 先顺着一个方向在茄子表面切出一道道细缝， 然后换个方向， 再一刀刀切下去， 这样茄子表面就成鱼鳞状了. 将改好的半边茄子一分为四. </p>
     <p>2.锅内烧油， 待油温6成热的时候， 放入茄子炸至变软捞起待用 (注意， 不要太软， 否则一炒就会烂掉的) 蒜， 姜切成细沫， 葱切花 </p>
     <p>3. 茄子是很吸油的， 所以炒的时候锅内只需放很少的油甚至不放油， 然后将茄子里渗出来的油到进锅内， 待锅烧到5成热的时候， 到入四川辣豆酱翻炒， 待到油变红， 豆瓣酱水份快收干的时候放入切好的蒜， 姜沫， 香味出来后， 倒入碎猪肉， 炒熟后倒入甜辣椒酱， 翻炒后倒入炸好的茄子， 盐， 炒匀后加入少许清水. 大火烧至水份快干时， 加入味精， 然后水淀粉勾芡， 最后放入葱花， 起锅装盘.</p>   <h2>小诀窍</h2><hr>
     <p>鱼香味主要是由泡辣椒, 豆瓣酱和葱花的味道混合而来的, 介于国外很难搞到泡辣椒所以就用味道相近的甜辣椒酱(主要成分, 辣椒, 醋, 糖)来代替. 倒甜辣椒酱的时候, 可以边倒边尝味道, 以免加少了, 鱼香味出不来, 加多了又太甜. 葱是鱼香味菜肴里起画龙点睛作用的, 用量不能少, 特别是葱白.</p>
     * name : 鱼香茄子
     * rcount : 0
     * status : true
     * url : http://www.tngou.net/cook/show/1
     */

    private int count;
    private String description;
    private int fcount;
    private String food;
    private int id;
    private String images;
    private String img;
    private String keywords;
    private String message;
    private String name;
    private int rcount;
    private boolean status;
    private String url;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
