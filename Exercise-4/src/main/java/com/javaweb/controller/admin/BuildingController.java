package com.javaweb.controller.admin;



import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;

import com.javaweb.service.BuildingSearchService;
import com.javaweb.service.BuildingService;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private UserService staffs;
    @Autowired
    private BuildingSearchService buildingSearchService;
    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/admin/building/list");
        List<BuildingSearchResponse> resultSearchBuilding = buildingSearchService.buildingSearchResponse(buildingSearchRequest);

        mav.addObject("buildingList", resultSearchBuilding);
        mav.addObject("modelSearch", buildingSearchRequest);
        mav.addObject("staffList", staffs.getStaffs());
        mav.addObject("districtList", DistrictCode.type());
        mav.addObject("typeCodeList", TypeCode.type());
        return mav;
    }
    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@ModelAttribute BuildingDTO buildingDTO, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("buildingEdit", buildingDTO);
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCodeList", TypeCode.type());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable("id") Long id,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        BuildingDTO building = buildingSearchService.searchBuildingById(id);

        // Bắt buộc phải có dòng này để gửi sang file edit.jsp
        mav.addObject("buildingEdit", building);
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCodeList", TypeCode.type());
        return mav;
    }
}
