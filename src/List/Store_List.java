package List;

import Bean.Store;

public class Store_List {

    private Store head_store;
    private int length;


    public Store_List() {
        head_store = new Store();
        length = 0;
    }

    public Store getHead_store() {
        return head_store;
    }

    public void setHead_store(Store head_store) {
        this.head_store = head_store;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean Insert_Store(int i, Store q) {//在第i个元素的位置插入元素q
        if (head_store == null) {
            System.out.println("L为空！\n");
            return false;
        }

        if (q == null) {
            return false;
        }
        if (i < 1 || i > length + 1) {
            System.out.println("所要插入的元素的下标不合法！");
            return false;
        }

        Store store;
        store = head_store;
        while (i > 1) {
            store = store.getNext_Store();
            if (store == null) {
                System.out.println("插入失败");
                return false;
            }
            i--;
        }

        Store p = store.getNext_Store();

        q.setNext_Store(p);

        store.setNext_Store(q);

        length++;
        //System.out.println("插入成功");
        return true;


    }

    public Store get_Store(int r) {

        if (head_store == null) {
            System.out.println("链表为空！");
            return null;
        }
        if (r < 1 || r > length) {
            System.out.println("所要获取的数据下标不合法！");
            return null;
        }

        Store p = head_store;
        while (r != 0) {
            p = p.getNext_Store();
            r--;
        }

        return p;
    }


    public boolean delete_Store(int i) {
        if (head_store == null) {
            System.out.println("链表为空！");
            return false;
        }

        if (i < 1 || i > length) {
            System.out.println("所要删除的元素的下标不合法！");
            return false;
        }

        Store p;
        Store q;
        p = head_store;
        while (i > 1) {//将p指向要删除节点的前一个元素
            p = p.getNext_Store();
            if (p == null) {
                System.out.println("删除失败！");
                return false;
            }
            i--;
        }

        q = p.getNext_Store();//q指向要删除的节点
        p.setNext_Store(q.getNext_Store());

        p = p.getNext_Store();

        while (p != null) {
            int k= Integer.parseInt(p.getId());
            k--;
            p.setId(String.valueOf(k));
            p=p.getNext_Store();
        }
        length--;
        System.out.println("删除成功！");

        return true;
    }
}
