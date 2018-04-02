<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
            
            <div class="weui-footer">
                <p class="weui-footer__text">Copyright © 2016-2030 创步科技</p>
            </div>
            
            <div class="weui-tabbar">
                <a href="/index" class="weui-tabbar__item weui-bar__item_on">
                    <span style="display: inline-block;position: relative;">
                        <img src="<%=request.getContextPath() %>/myres/img/base/home_info.png" alt="" class="weui-tabbar__icon">
                    </span>
                    <p class="weui-tabbar__label">主页</p>
                </a>
                <a href="javascript:;" class="weui-tabbar__item" onClick="openUrl('${basepath}','/service/serviceNavigation')">
                    <img src="<%=request.getContextPath() %>/myres/img/base/server_info.png" alt="" class="weui-tabbar__icon">
                    <p class="weui-tabbar__label">为您服务</p>
                </a>
                <a href="javascript:;" class="weui-tabbar__item" onClick="openUrl('${basepath}','/suggestion/suggestion')">
                    <span style="display: inline-block;position: relative;">
                        <img src="<%=request.getContextPath() %>/myres/img/base/suggestion_info.png" alt="" class="weui-tabbar__icon">
                    </span>
						
                    <p class="weui-tabbar__label">投诉建议</p>
                </a>
                <a href="javascript:;" class="weui-tabbar__item" onClick="openUrl('${basepath}','/operation/operation')">
                    <img src="<%=request.getContextPath() %>/myres/img/base/operation_info.png" alt="" class="weui-tabbar__icon">
                    <p class="weui-tabbar__label">操作指南</p>
                </a>
            </div>
