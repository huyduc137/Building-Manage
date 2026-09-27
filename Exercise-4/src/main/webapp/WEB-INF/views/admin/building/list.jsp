<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/><!DOCTYPE html>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check("breadcrumbs", "fixed");
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a></li>
                <li class="active">Dashboard</li>
            </ul>
            <!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Dashboard <small> <i class="ace-icon fa fa-angle-double-right"></i> overview &amp; stats
                </small>
                </h1>
            </div>
            <!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box ui-sortable-handle">
                        <div class="widget-header">
                            <h5 class="widget-title">Tìm Kiếm</h5>
                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse"> <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>

                        <div class="widget-body" style="font-family: 'Times New Roman', Times, serif">
                            <div class="widget-main">
                                <form:form id="listForm" action="${buildingListURL}" method="GET" modelAttribute="modelSearch">
                                    <div class="row">
                                        <!-- Dòng 1 -->
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <div class="col-xs-6">
                                                    <label class="name">Tên tòa nhà</label>
                                                        <%--                                                    <input type="text" class="form-control" name="name" value="${modelSearch.name}"/>--%>
                                                    <form:input class="form-control" path="name"/>
                                                </div>
                                                <div class="col-xs-6">
                                                    <label class="name">Diện tích sàn</label>
                                                    <!-- 														<input type="number" class="form-control" name="floorArea" value="" /> -->
                                                    <form:input class="form-control" path="floorArea"/>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Dòng 2 -->
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <div class="col-xs-2">
                                                    <label class="name">Quận</label>
                                                    <form:select class="form-control" path="district">
                                                        <form:option value="">--Chọn Quận--</form:option>
                                                        <form:options items="${districtList}" />
                                                    </form:select>
                                                </div>
                                                <div class="col-xs-5">
                                                    <label class="name">Phường</label>
                                                    <!-- 														<input type="text" class="form-control" name="ward" value="" /> -->
                                                    <form:input class="form-control" path="ward"/>
                                                </div>
                                                <div class="col-xs-5">
                                                    <label class="name">Đường</label>
                                                    <!-- 														<input type="text" class="form-control" name="street" value="Candy" /> -->
                                                    <form:input class="form-control" path="street"/>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Dòng 3 -->
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <div class="col-xs-4">
                                                    <label class="name">Số tầng hầm</label>
                                                    <!-- 														<input type="text" class="form-control" name="numberOfBasement" value="3" /> -->
                                                    <form:input class="form-control" path="numberOfBasement"/>
                                                </div>
                                                <div class="col-xs-4">
                                                    <label class="name">Hướng</label>
                                                    <!-- 														<input type="text" class="form-control" name="direction" value="" /> -->
                                                    <form:input class="form-control" path="direction"/>
                                                </div>
                                                <div class="col-xs-4">
                                                    <label class="name">Hạng</label>
                                                    <!-- 														<input type="text" class="form-control" name="level" value="" /> -->
                                                    <form:input class="form-control" path="level"/>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Dòng 4 -->
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <div class="col-xs-3">
                                                    <label class="name">Diện tích từ</label>
                                                        <%--														<input type="text" class="form-control" name="areaFrom" value="" />--%>
                                                    <form:input class="form-control" path="areaFrom"/>
                                                </div>
                                                <div class="col-xs-3">
                                                    <label class="name">Diện tích đến</label>
                                                        <%--														<input type="text" class="form-control" name="areaTo" value="" />--%>
                                                    <form:input class="form-control" path="areaTo"/>
                                                </div>
                                                <div class="col-xs-3">
                                                    <label class="name">Giá thuê từ</label>
                                                        <%--														<input type="text" class="form-control" name="priceFrom" value="" />--%>
                                                    <form:input class="form-control" path="rentPriceFrom"/>
                                                </div>
                                                <div class="col-xs-3">
                                                    <label class="name">Giá thuê đến</label>
                                                        <%--														<input type="text" class="form-control" name="priceTo" value="" />--%>
                                                    <form:input class="form-control" path="rentPriceTo"/>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Dòng 5 -->
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <div class="col-xs-5">
                                                    <label class="name">Tên quản lý</label>
                                                        <%--														<input type="text" class="form-control" name="managerName" value="" />--%>
                                                    <form:input class="form-control" path="managerName"/>
                                                </div>
                                                <div class="col-xs-5">
                                                    <label class="name">Số điện thoại quản lý</label>
                                                        <%--														<input type="text" class="form-control" name="managerPhone" value="" />--%>
                                                    <form:input class="form-control" path="managerPhone"/>
                                                </div>
                                                <div class="col-xs-2">
                                                    <label class="name">Nhân viên</label>
                                                    <form:select class="form-control" path="staffId">
                                                        <form:option value="">--Chọn Nhân Viên--</form:option>
                                                        <form:options items="${staffList}" />
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Dòng 6 -->
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-6">
                                                        <form:checkboxes items="${typeCodeList}" path="typeCode"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Dòng 7 -->
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <button class="btn btn-danger" id="btnSearchBuilding">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                                                        </svg>
                                                        Tìm kiếm
                                                    </button>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </form:form></div>
                        </div>

                        <div class="pull-right">
                            <a href="<c:url value='/admin/building-edit'/>">
                                <button class="btn btn-info" title="Thêm tòa nhà">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>
                                </button>
                            </a> <a href="<c:url value='/admin/building-edit'/>">
                            <button class="btn btn-danger" title="Xóa tòa nhà" id="btnDeleteBuilding">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Bảng danh sách tòa nhà -->
            <div class="row">
                <div class="col-xs-12" style="font-family: 'Times New Roman', Times, serif">
                    <table id="tableList" style="margin: 3em 0 1.5em" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center"><label class="pos-rel">
                                <input type="checkbox" class="ace"/>
                                <span class="lbl"></span>
                            </label></th>
                            <th>Tên tòa nhà</th>
                            <th>Địa chỉ</th>
                            <th>Số tầng hầm</th>
                            <th>Tên quản lý</th>
                            <th>Số điện thoại quản lý</th>
                            <th>Diện tích sàn</th>
                            <th>Diện tích trống</th>
                            <th>Diện tích thuê</th>
                            <th>Giá thuê</th>
                            <th>Phí dịch vụ</th>
                            <th>Phí môi giới</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>

                        <tbody>
							<c:forEach var="item" items="${buildingList}">
								<tr class="active">
									<td class="center">
										<label class="pos-rel">
											<input type="checkbox" class="ace" name="checkList" value="${item.id}"/>
											<span class="lbl"></span>
										</label>
									</td>

									<td>${item.name}</td>
									<td>${item.address}</td>
									<td>${item.numberOfBasement}</td>
									<td>${item.managerName}</td>
									<td>${item.managerPhone}</td>
									<td>${item.floorArea}</td>
									<td>${item.emptyArea}</td>
									<td>${item.rentArea}</td>
									<td>${item.rentPrice}</td>
									<td>${item.serviceFee}</td>

									<td>${item.id}</td>

									<td>
										<div class="hidden-sm hidden-xs btn-group">
											<button class="btn btn-xs btn-success" title="Giao tòa nhà" onclick="assignmentBuilding(${item.id})">
												<i class="ace-icon glyphicon glyphicon-list"></i>
											</button>

											<a class="btn btn-xs btn-info" title="Chỉnh sửa tòa nhà" href="<c:url value='/admin/building-edit-${item.id}'/>">
												<i class="ace-icon fa fa-pencil bigger-120"></i>
											</a>

											<button class="btn btn-xs btn-danger" title="Xóa tòa nhà" onclick="deleteBuilding(${item.id})">
												<i class="ace-icon fa fa-trash-o bigger-120"></i>
											</button>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
                    </table>
                    <div class="btn-group pull-right">
                        <button type="button" class="btn">1</button>
                        <button type="button" class="btn">2</button>
                        <button type="button" class="btn">3</button>
                    </div>
                </div>
                <!-- /.span -->
            </div>
        </div>
        <!-- /.page-content -->
    </div>
</div>
<!-- /.main-content -->

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>

<!-- /.main-container -->

<!-- The Modal -->
<div class="modal" id="assignmentBuildingModal" role="dialog" style="font-family: 'Times New Roman', Times, serif">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header" style="display: flex; align-items: center; justify-content: space-between">
                <h4 class="modal-title" style="margin: 0">Danh sách nhân viên</h4>
                <button type="button" class="close" data-dismiss="modal" style="margin: 0; padding: 0; line-height: 1">
                    &times;
                </button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <table style="margin: 3em 0 1.5em" id="staffList" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>chọn</th>
                            <th>Tên nhân viên</th>
                        </tr>
                    </thead>

                    <tbody>
<%--                    <tr>--%>
<%--                        <td class="center"><input type="checkbox" id="checkbox_1" value="1"/></td>--%>

<%--                        <td>Nguyễn Đức Huy</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td class="center"><input type="checkbox" id="checkbox_2" value="2"/></td>--%>

<%--                        <td>Nguyễn Đức Anh</td>--%>
<%--                    </tr>--%>
                    </tbody>
                </table>
                <input type="hidden" id="buildingId" name="buildingId" value=""/>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="btnAssignmentBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<script>

    function assignmentBuilding(buildingId) {
        $("#assignmentBuildingModal").modal();
        $("#buildingId").val(buildingId);    // set buildingId cho modal
        loadStaff(buildingId);
    }

    function loadStaff(buildingId) {
        $.ajax({
            type: "GET",
            url:"/api/building/" + buildingId + "/staffs",
            data:JSON.stringify(buildingId),
            dataType: "JSON",
            contentType: "application/json",
            success: function(response) {
                var row = '';
                $.each(response.data, function(index, item){
                    row += '<tr>';
                    row += '<td class="center"><input type="checkbox" class="check-box-element" id="checkbox_"' + item.staffId + ' value=' + item.staffId + ' ' + item.checked + ' /></td>';
                    row += '<td>' + item.fullName + '</td>';
                    row += '</tr>';
                });
                $("#staffList tbody").html(row);
                console.log("Success!");
            },
            error: function(response) {
                console.log(response);
            }
        });
    }

    $("#btnAssignmentBuilding").click(function (e) {
        e.preventDefault();
        var data = {};
        data["buildingId"] = $("#buildingId").val();
        var staffs = $("#staffList").find("tbody input[type=checkbox]:checked").map(function () {
            return $(this).val();
        }).get();
        data["staffs"] = staffs;
        if (data["staffs"] != '') {
            callAPIAssignmentBuilding(data);
        }
        console.log("OK")
    })
    function callAPIAssignmentBuilding(data) {
        $.ajax({
            type: "POST",
            url:"/api/building/" + "assignment",
            data:JSON.stringify(data),
            dataType: "JSON",
            contentType: "application/json",
            success: function(response) {
                console.log("Success!");
                window.location.href = "/admin/assignment/success";
            },
            error: function(error) {
                console.log("error");
                window.location.href = "/admin/assignment/error";
            }
        });
    }

    $('#btnSearchBuilding').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();
    });

    function deleteBuilding(id) {
        var buildingId = [id];
        deleteBuildings(buildingId);
    }
    $("#btnDeleteBuilding").click(function (e) {
        e.preventDefault();
        var buildingIds = $("#tableList").find("tbody input[type=checkbox]:checked").map(function () {
            return $(this).val();
        }).get();
        deleteBuildings(buildingIds);
    })
    function deleteBuildings(data) {
        $.ajax({
            type: "DELETE",
            url: "/api/building/" + data,
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                console.log("success");
                window.location.href = "/admin/success";
            },
            error: function (error) {
                console.log("error");
                window.location.href = "/admin/error";
            },
        });
    }

</script>

</body>
</html>