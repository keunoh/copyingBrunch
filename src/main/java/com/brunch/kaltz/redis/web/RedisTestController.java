package com.brunch.kaltz.redis.web;

import com.brunch.kaltz.redis.domain.Member;
import com.brunch.kaltz.redis.service.RedisTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/redisTest")
@RestController
public class RedisTestController {

    private final RedisTestService redisTestService;

    @GetMapping("/open")
    public ModelAndView openRedisPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redis/Redis");
        return modelAndView;
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<?> getMemberInfo(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(redisTestService.getMemberInfo(memberId));
    }

    @PostMapping("")
    public ResponseEntity<?> joinMember(@RequestBody Map<String, String> memberInfo) {
        log.debug("memberInfo : {}", memberInfo);
        Member member = new Member();
        member.setName(memberInfo.get("name"));
        redisTestService.joinMember(member);
        return ResponseEntity.ok("join success!");
    }

    @PutMapping("")
    public ResponseEntity<?> updateMember(@RequestBody Map<String, String> memberInfo) {
        log.debug("memberInfo : {}", memberInfo);
        Member member = new Member();
        member.setId(Long.parseLong(memberInfo.get("id")));
        member.setName(memberInfo.get("name"));
        redisTestService.updateMember(member, member.getId());
        return ResponseEntity.ok("update success!");
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> deleteMember(@PathVariable("memberId") Long memberId) {
        redisTestService.removeMember(memberId);
        return ResponseEntity.ok("delete success!");
    }
}
