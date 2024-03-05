package member;

import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import enums.Messenger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemberServiceImpl extends AbstractService<Member> implements MemberService {
    private static MemberServiceImpl instance = new MemberServiceImpl();
    Map<String, Member> members;

    public MemberServiceImpl() {
        this.members = new HashMap<>();
    }
    public static MemberServiceImpl getInstance(){
        return instance;
    }

    @Override
    public List<Member> getUserList() {
        return new ArrayList<>(members.values());
    }

    @Override
    public String addUsers() {
        IntStream.range(0,5)
                .mapToObj(i -> UtilServiceImpl.getInstance().createRandomUsername())
                .forEach(i -> members.put(i, Member.builder()
                        .username(i)
                        .password("1")
                        .name(UtilServiceImpl.getInstance().createRandomName())
                        .job(UtilServiceImpl.getInstance().createRandomJob())
                        .build()));
        return members.size()+"개 더미값 추가";
    }

    @Override
    public Member findUser(String username) {
        return members.get(username);
    }

    @Override
    public String login(Member input) {
        Member member = members.get(input.getUsername());
        if(member == null){
            return "회원정보가 없습니다.";
        } else if(member.getPassword().equals(input.getPassword())){
            return "로그인 성공";
        } else {
            return "패스워드가 일치하지 않습니다.";
        }
    }

    @Override
    public List<?> findUsersByName(String name) {
        return members
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return members
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String changePassword(Member member) {
        if(members.get(member.getUsername()) == null){
            return "존재하지 않는 회원입니다.";
        } else {
            members.get(member.getUsername()).setPassword(member.getPassword());
            return "비밀번호 변경 완료";
        }
    }

    @Override
    public Messenger save(Member member) {
        members.put(member.getUsername(), member);
        return Messenger.SUCCESS;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Optional<Member> findById(Long id) {
        return members
                .values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    @Override
    public String count() {
        return members.size()+"";
    }

    @Override
    public Optional<Member> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Member member) {
        members.remove(member.getUsername());
        return "회원삭제";
    }

    @Override
    public Boolean existById(Long id) {
        return members.containsKey(id);
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return members
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return members
                .entrySet()
                .stream()
                .filter(i -> i.getValue().getJob().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public Map<String, ?> getUserMap() {
        return members;
    }
}
