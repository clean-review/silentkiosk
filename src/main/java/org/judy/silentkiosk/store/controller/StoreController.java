package org.judy.silentkiosk.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.judy.silentkiosk.store.dto.StoreDTO;
import org.judy.silentkiosk.store.dto.StoreMenuDTO;
import org.judy.silentkiosk.store.dto.StoreToppingDTO;
import org.judy.silentkiosk.store.service.MenuService;
import org.judy.silentkiosk.store.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreService service;
    private final MenuService menuService;

    //가게 정보
    @CrossOrigin
    @GetMapping(value = "/{sno}", produces = "application/json")
    public ResponseEntity<StoreDTO> selectList(@PathVariable("sno") Long sno) {

        log.info("list..............");

        StoreDTO store= service.getStoreBySno(sno);

        return new ResponseEntity<StoreDTO>(store, HttpStatus.OK);
    }

    //메뉴 리스트
    @CrossOrigin
    @GetMapping(value = "/menulist/{sno}", produces = "application/json")
    public ResponseEntity<List<StoreMenuDTO>> getMenu(@PathVariable("sno") Long sno) {

        log.info("menu..............");

        List<StoreMenuDTO> menuList= service.getStoreMenu(sno);

        return new ResponseEntity<List<StoreMenuDTO>>(menuList, HttpStatus.OK);
    }

    //메뉴 선택시 토핑 가져오기
    @CrossOrigin
    @GetMapping(value = "/getmenutopping/{mno}", produces = "application/json")
    public ResponseEntity<List<StoreToppingDTO>> getMenuToppingOne(@PathVariable("mno") Long mno) {

        log.info("menuToppingOne...............");

        List<StoreToppingDTO> topping = menuService.getMenuTopping(mno);

        return new ResponseEntity<List<StoreToppingDTO>>(topping, HttpStatus.OK);
    }

    //메뉴 선택시 메뉴 가져오기
    @CrossOrigin
    @GetMapping(value = "/getmenu/{mno}", produces = "application/json")
    public ResponseEntity<StoreMenuDTO> getMenuOne(@PathVariable("mno") Long mno) {

        log.info("menuOne............................");

        StoreMenuDTO menu = menuService.getMenu(mno);

        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

}
