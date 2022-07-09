package hello.jpa;

import org.hibernate.metamodel.internal.MapMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //emf 는 로딩시점에 DB 당 하나만 만들어야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //쓰레드간 공유를 하면 안된다. 사용하고 무조건 버리도록 한다.
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            //Member findMember = em.find(Member.class, 1L);
//            //JPQL 을 예시
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            //JPQL 을 사용하여 받아온 List 를 출력하기
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }
//
//            /**
//             * 영속성 컨텍스트 예시
//             */
//            //비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloPersistenceContext");
//
//            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member); //1차 캐시에 저장
//            System.out.println("=== AFTER ===");
//
//            //1차캐시에서 꺼내서 findMember를 가져오기 때문에 DB가 아닌 1차캐시에서 꺼내오는 거임
//            Member findMember = em.find(Member.class, 100L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            //----------------------------------------------------
//            //jpa는 영속 entity의 동일성을 보장한다
//            Member findMember = em.find(Member.class, 1L);
//            Member findMember2 = em.find(Member.class, 1L);
//            System.out.println("result = "+ (findMember==findMember2));


//            //-------------------
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            //영속 컨텍스트에 쌓이고 있음
//            em.persist(member1);
//            em.persist(member2);


//            //==================================
//            Member member = em.find(Member.class, 150L);
//            member.setName("zzzz");
//
//            System.out.println("=========================");

//            //-----------------------------------
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            //tx.commit 이 되기전에 sql이 반영이 됨
//            em.flush();
//            System.out.println("===============================");
//            //--------------------------------------



            //트랜잭션을 적용
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();



    }
}
