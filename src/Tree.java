public class Tree {
    private Node root;  // ağacın kök elemanının erişim bilgisi// yapıcı işlev, kökü olmayan boş bir ağaç tanımlar
    public Tree() {
        root=null;
    }
    // insert işlevi, key değerine sahip elemanı ağaca ekler
    public void insert(int key) {
        root=insert(key,root);  // özyinelemeli iç işlevi çağır
    }
    // parametrede verilen key değerine sahip elemanı, kökü t olan ağaca veya alt ağaca ekler
// özyinelemeli iç işlev, öz nitelik erişimi olmadığı için “static”
    private static Node insert(int key, Node t) {
        if(t==null)                    // kök yoksa (bu alt ağaç boşsa),
            t=new Node(key,null,null);   // yeni eleman kök olsun
        else if(key<t.key)             // eklenecek değer, kök elemanından küçükse
            t.leftChild=insert(key,t.leftChild);   // yeni elemanı sol alt ağaca ekle
        else if(key>t.key)             // eklenecek değer, kök elemanından büyükse
            t.rightChild=insert(key,t.rightChild); // yeni elemanı sağ alt ağaca ekle
        else ;                         // eklenecek değer, kök elemanına eşitse, bir şey yapma
        return t;                      // bu alt ağacın kök eleman erişim bilgisini döndür
    }
    // search işlevi, key değerine sahip elemanı bulup erişim bilgisini verir
    public Node search(int key) {
        return search(key,root);  // özyinelemeli iç işlevi çağır
    }
    // parametrede verilen key değerine sahip elemanı, kökü t olan ağacın veya alt ağacın altında arar
// özyinelemeli iç işlev, öz nitelik erişimi olmadığı için “static”
    private static Node search(int key, Node t) {
        if(t==null)                    // kök yoksa (bu alt ağaç boşsa),
            return null;                 // bulamadık
        else if(key<t.key)             // aranılan değer, kök elemanından küçükse
            return search(key,t.leftChild);  // sol alt ağaçta ara
        else if(key>t.key)             // aranılan değer, kök elemanından büyükse
            return search(key,t.rightChild); // sağ alt ağaçta ara
        else                           // aranılan değer, kök elemanından eşitse
            return t;                    // bulduk: elemanın erişim bilgisini döndür
    }
    // remove işlevi, key değerine sahip elemanı bulup siler
    public void remove(int key) {
        root=remove(key,root);  // özyinelemeli iç işlevi çağır
    }
    // parametrede verilen key değerine sahip elemanı, kökü t olan ağacın veya alt ağacın altında arayıp siler
// özyinelemeli iç işlev, öz nitelik erişimi olmadığı için “static”
    private static Node remove(int key, Node t) {
        if(t==null)                    // kök yoksa (bu alt ağaç boşsa),
            return t;                    // bulamadık
        if(key<t.key)                  // silinecek değer, kök elemanından küçükse
            t.leftChild=remove(key,t.leftChild);   // sol alt ağaçta ara
        else if(key>t.key)             // silinecek değer, kök elemanından büyükse
            t.rightChild=remove(key,t.rightChild); // sağ alt ağaçta ara
        else                           // bulduk: silelim
            if(t.leftChild!=null && t.rightChild!=null) {  // silinecek elemanın 2 çocuğu (alt ağacı) varsa
                t.key=findMax(t.leftChild).key;         // sol alt ağacının en büyüğü silinecek olanın yerini alsın
                t.leftChild=remove(t.key,t.leftChild);  // şimdi bu en büyüğü sol alt ağaçtan silelim
            }
            else if(t.leftChild!=null)   // yalnızca sol çocuğu varsa,
                t=t.leftChild;             // sol çocuk, silinecek olanın yerine gelsin
            else                         // yoksa,
                t=t.rightChild;            // sağ çocuk, silinecek olanın yerine gelsin
        return t;                      // bu alt ağacın kök elemanının erişim bilgisini döndür
    }
    // findMax işlevi, ağacın en büyük elemanının erişim bilgisini verir
    public Node findMax() {
        if(root==null) return null;    // ağaç boşsa, null döndür
        return findMax(root);          // (değilse) özyinelemeli iç işlevi çağır
    }
    // kökü t olan ağacın veya alt-ağacın en büyük elemanının erişim bilgisini verir
// özyinelemeli iç işlev, öz nitelik erişimi olmadığı için “static”
    private static Node findMax(Node t) {
        if(t.rightChild==null) return t;  // sağ çocuğu yoksa, en büyük bu
        return findMax(t.rightChild);     // varsa, sağ çocukla devam et
    }
    // findMin işlevi, ağacın en küçük elemanının erişim bilgisini verir
    public Node findMin() {
        Node t=root;                   // kökten başla
        if(t!=null)                    // ağaç boş değilse,
            while(t.leftChild!=null)     // sol çocuk boş olmadığı sürece,
                t=t.leftChild;             // sol taraftan devam et
        return t;                      // sol çocuğu olmayan bu en sol, en alt elemanı döndür
    }
}

