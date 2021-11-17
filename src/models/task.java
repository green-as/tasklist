package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity//エンティティクラスであることを指定

/*タスクの内容を一覧表示するための内容
 * クエリとは問い合わせ
 * 一件取得する find() メソッドに近い形で複数件のデータを取得する
 * メソッドは存在していませんので、JPQL と呼ばれる少し特殊な
 * SQL文（SELECT文）を Message クラスに用意する必要があります。
 * SELECT mはsqlでいうSELECT *と同じですべての
 * レコードを取得という意味
 * ORDER BYは表示順を並べ替える
 * ORDER BY カラム名 のあとに DESCとすると大きい順（降順）への並び替え
 * られた状態で取得できる
 * つまりIDの数が大きい順に一覧表示が並ぶということ
 * */
@NamedQueries({
        @NamedQuery(
                name = "getAllMessages",
                query = "SELECT m FROM task AS m ORDER BY m.id DESC"
                )
})

@Table(name = "tasks")//テーブル名を指定
public class task {

  //idという主キーをフィールドに指定（つまりidを主キーと指定）
    @Id

  //Entityの各フィールドにマッピングされるテーブルのカラム名を指定
    @Column(name = "id")

    /*strategy属性の４種類あるうちの一種
    ID列(GenerationType.IDENTITY)を利用して，自動採番で
    プライマリキー値を生成する。*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*インスタンスなのでクラス型（参照型）のIntegerを使用?
     質問中*/
    private Integer id;

    /*@Column アノテーションの ( ..., nullable = false) で
     * 必須入力が設定されています（nullable、
     * つまりnullを許容するか否かの設定で、true だとnullを許容し、
     * falseだと許容しないことになります）*/
    @Column(name = "content",length = 255, nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }


}
