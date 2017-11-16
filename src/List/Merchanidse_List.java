package List;

import Bean.Merchanidse;


public class Merchanidse_List {
    private Merchanidse head_merchanidse;
    private int length;

    public Merchanidse getHead_merchanidse() {
        return head_merchanidse;
    }

    public void setHead_merchanidse(Merchanidse head_merchanidse) {
        this.head_merchanidse = head_merchanidse;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Merchanidse_List() {
        head_merchanidse = new Merchanidse();
        length = 0;
        System.out.println("初始化成功～");
    }

    public boolean ClearList() {
        Merchanidse merchanidse = head_merchanidse.getNext_merchanidse();
        Merchanidse merchanidse1;
        while (merchanidse != null) {
            merchanidse1 = merchanidse.getNext_merchanidse();
            merchanidse = null;
            merchanidse = merchanidse1;
        }

        head_merchanidse.setNext_merchanidse(null);
        System.out.println("清空成功～");
        return true;

    }

    public boolean IsEmpty() {

        if (length == 0) {
            System.out.println("链表为空～");
            return true;
        } else {
            System.out.println("链表不为空～");
            return false;
        }
    }

    public Merchanidse GetElem(int n) {
        if (n < 1 || n > length) {
            System.out.println("链表不为空～");
            return null;
        }
        Merchanidse p = head_merchanidse;
        while (n != 0) {
            p = p.getNext_merchanidse();
            n--;
        }

        return p;
    }




}



/*
//
// Created by dmrf on 17-10-




int LocateElem(SqList L, int e, bool compare(int a, int b)) {//返回第一个与e符合compare的元素的位序
    if (ListEmpty(L)) {
        cout << "链表为空！" << endl;
        return -1;
    }

    LNode *p = L.head->next;
    for (int i = 0; i < L.length; ++i) {
        if (compare(e, p->date)) {
            cout << "找到符合条件的元素,位序为：" << i+1 << endl;
            return i;
        }
        p = p->next;
    }
    cout << "没有找到符合条件的元素" << endl;
    return -1;
}

bool PriorElem(SqList L, int cur_e, int &pre_e) {//求前驱
    if (ListEmpty(L)) {
        cout << "链表为空！" << endl;
        return false;
    }

    LNode *p = L.head;
    LNode *q = L.head->next;
    if (cur_e == q->date) {
        cout << cur_e << "为首元素，无前驱" << endl;
        return false;
    }

    p = q;
    q = q->next;

    while (q != NULL) {
        if (q->date == cur_e) {
            pre_e = p->date;
            return true;
        }

        p = q;
        q = q->next;
    }

    cout << cur_e << "无前驱" << endl;
    return false;

}

bool NextElem(SqList L, int cur_e, int &next_e) {
    if (ListEmpty(L)) {
        cout << "链表为空！" << endl;
        return false;
    }
    LNode *p, *q;
    p = L.head->next;
    while (p != NULL) {
        q = p->next;
        if (p->date == cur_e) {
            if (q != NULL) {
                next_e = q->date;
                return true;
            } else {
                cout << cur_e << "无后继" << endl;
                return false;
            }
        }
     p=q;
    }
    cout << cur_e << "无后继" << endl;
    return false;
}

bool ListInsert(SqList &L, int i, int q) {//在第i个元素的位置插入元素q

    if (L.head == NULL) {
        printf("L为空！\n");
        return false;
    }

    if (i < 1 || i > L.length + 1) {
        cout << "所要插入的元素的下标不合法！" << endl;
        return false;
    }

    LNode *p;
    p = L.head;
    while (i > 1) {
        p = p->next;
        if (p == NULL) {
            cout << "插入失败" << endl;
            return false;
        }
        i--;
    }

    LNode *lNode = new LNode();
    lNode->date = q;

    lNode->next = p->next;
    p->next = lNode;
    L.length++;
    cout << "插入成功" << endl;
    return true;
}

bool ListDelete(SqList &L, int i, int &e) {//删除第i个数据元素，并用e返回其值
    if (ListEmpty(L)) {
        cout << "链表为空！" << endl;
        return false;
    }

    if (i < 1 || i > L.length) {
        cout << "所要删除的元素的下标不合法！" << endl;
        return false;
    }

    LNode *p;
    LNode *q;
    p = L.head;
    while (i > 1) {//将p指向要删除节点的前一个元素
        p = p->next;
        if (p == NULL) {
            cout << "删除失败" << endl;
            return false;
        }
        i--;
    }

    q = p->next;//q指向要删除的节点
    p->next = q->next;
    free(q);
    L.length--;

    cout << "删除成功" << endl;
    return true;

}


bool ListTraverse(SqList L, bool Visit(int k)) {
    if (ListEmpty(L)) {
        cout << "链表为空！" << endl;
        return false;
    }
    LNode *p;
    p = L.head->next;
    while (p != NULL) {
        Visit(p->date);
        p=p->next;
    }
    return true;
}


#endif //ADTLIST_ADT_LIST_SEQUENCE_H
 */