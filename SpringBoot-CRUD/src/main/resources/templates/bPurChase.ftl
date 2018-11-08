<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SpringBoot-CRUD</title>
<script src="http://127.0.0.1:8080/crud/js/jquery-3.2.1.min.js"></script>
<link href="http://127.0.0.1:8080/crud/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="http://127.0.0.1:8080/crud/bootstrap/js/bootstrap.min.js"></script>
<!--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>-->
<script type="text/javascript">
 function bPurChaseUpdate(id){
     $.ajax({  
            url:"bPurChase/"+id,
            type:"GET",
            success:function(data){
             $("#id").val(data.id);
             $("#goodsNumber").val(data.goodsNumber);
             $("#goodsCount").val(data.goodsCount);
             $("#price").val(data.price);
             $("#status").val(data.status);
             $("#contactPerson").val(data.contactPerson);
             $("#personTel").val(data.personTel);
             $("#goodsName").val(data.goodsName);
             $("#supplierName").val(data.supplierName);
             $("#remark").val(data.remark);
           },  
            error:function(){  
                console.log("失败");  
            }  
        })  
      $('#bPurChaseUpdateModal').modal('show');
  }
</script>
</head>
<body>
<!-- 货品入库更新 -->
<div class="modal fade" id="bPurChaseUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">货品入库更新 </h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal">
          <input type="hidden" id="id" name="id">
          <input type="hidden" id="status" name="status">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-3 control-label">货品批号</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" disabled name="goodsNumber" id="goodsNumber">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">货品名称</label>
		    <div class="col-sm-9">
		      <select class="form-control" id="goodsName" name="goodsName">
		          <option value="">--请选择--</option>
				  <option value="金属填油挂件钥匙扣">金属填油挂件钥匙扣</option>
				  <option value="蝴蝶钥匙扣">蝴蝶钥匙扣</option>
				  <option value="足球运动系列钥匙扣">足球运动系列钥匙扣</option>
				  <option value="金属钥匙扣">金属钥匙扣</option>
				</select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">数量</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="goodsCount" id="goodsCount">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">单价</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="price"  id="price">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">供应商名称</label>
		    <div class="col-sm-9">
		   <select class="form-control" id="supplierName" name="supplierName">
		          <option value="">--请选择--</option>
				  <option value="中山市常胜金属制品有限公司">中山市常胜金属制品有限公司</option>
				  <option value="中山市乐格工艺品有限公司">中山市乐格工艺品有限公司</option>
			</select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">联系人</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="contactPerson" id="contactPerson">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">联系人电话</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="personTel" id="personTel">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">备注</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="3" name="remark"></textarea>
		    </div>
		  </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="bPurChase_update_btn">保存</button>
      </div>
    </div>
  </div>
</div>
<!-- 货品入库新增 -->
<div class="modal fade" id="bPurChaseAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">货品入库新增 </h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-3 control-label">货品批号</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="goodsNumber" id="goodsNumber">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">货品名称</label>
		    <div class="col-sm-9">
		       <select class="form-control" id="selectgoodsName" name="goodsName">
		          <option value="">--请选择--</option>
				  <option value="金属填油挂件钥匙扣">金属填油挂件钥匙扣</option>
				  <option value="蝴蝶钥匙扣">蝴蝶钥匙扣</option>
				  <option value="足球运动系列钥匙扣">足球运动系列钥匙扣</option>
				  <option value="金属钥匙扣">金属钥匙扣</option>
				</select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">数量</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="goodsCount" id="goodsCount">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">单价</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="price"  id="price">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">供应商名称</label>
		    <div class="col-sm-9">
		    <select class="form-control" name="supplierName">
		          <option value="">--请选择--</option>
				  <option value="中山市常胜金属制品有限公司">中山市常胜金属制品有限公司</option>
				  <option value="中山市乐格工艺品有限公司">中山市乐格工艺品有限公司</option>
			</select>
			
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">联系人</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="contactPerson" id="contactPerson">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">联系人电话</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" name="personTel" id="personTel">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-3 control-label">备注</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="3" name="remark"></textarea>
		    </div>
		  </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="bPurChase_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>
 <div class="container">
   <!-- 标题 --> 
   <div class="row">
     <div class="col-md-12">
      <h1>SpringBoot+mybatis+pagehelper(mybatis分页插件)+freemarker+Bootstrap</h1>
      <h1>CRUD</h1>
     </div>
   </div>
    <!-- 按钮 -->
    <div class="row">
      <div class="col-md-4 col-md-offset-8">
      <button class="btn btn-primary" type="button" id="bPurChaseAdd">新增</button>
      <button class="btn btn-danger" type="button" id="bPurChaseDelete">删除</button>
      </div>
   </div>
   <!-- 显示表格数据 --> 
   <div class="row">
      <div class="col-md-12">
        <table class="table table-hover">
          <tr>
          <th><input type="checkbox" id="allChecked" onclick="selAll(this.checked);"/></th>
          <th>#</th>
          <th>货品批号</th>
          <th>数量</th>
          <th>单价</th>
          <th>状态</th>
          <th>供应商名称</th>
          <th>联系人</th>
          <th>联系人电话</th>
          <th>货品名称</th>
           <th>操作</th>
         </tr>
          <#list list as bPurChase> 
         <tr>
          <td><input type="checkbox"  name="cbsel" value="${bPurChase.id}"></td>
          <td>${bPurChase_index+1}</td>
          <td>${bPurChase.goodsNumber}</td>
          <td>${bPurChase.goodsCount}</td>
          <td>${bPurChase.price}</td>
          <td>${bPurChase.status1}</td>
          <td>${bPurChase.supplierName}</td>
          <td>${bPurChase.contactPerson}</td>
          <td>${bPurChase.personTel}</td>
          <td>${bPurChase.goodsName}</td>
           <td>
                  <a href="javascript:bPurChaseUpdate('${bPurChase.id}');">编辑</a>
                  <a href="javascript:if(confirm('确认删除该条信息吗？'))document.location='delete/${bPurChase.id}'">删除</a>
           </td>
          </tr>
          </#list>
        </table>
      </div>
   </div>
   <!-- 显示分页信息--> 
   <div class="row">
    <!-- 分页文字信息--> 
   <div class="col-md-6">
           当前${page.pageNum}页  总${page.pages}页 总${page.total}条记录
   </div>
   <!-- 分页条信息--> 
   <div class="col-md-6">
     <nav aria-label="Page navigation">
		  <ul class="pagination">
		       <li><a href="list?page=${page.firstPage}">首页</a></li>
		    <#if page.hasPreviousPage>
		    <li>
		      <a href="list?page=${page.prePage}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    </#if>
		    <#list page.navigatepageNums as pageNum>
		     <li <#if pageNum==page.pageNum>class="active"</#if>><a href="list?page=${pageNum}">${pageNum}</a></li>
		    </#list>
		    <#if page.hasNextPage >
		    <li>
		      <a href="list?page=${page.nextPage}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    </#if>
		     <li><a href="list?page=${page.lastPage}">末页</a></li>
		  </ul>
		</nav>
   </div>
       
   </div>
 </div>
 <script>
  $("#bPurChaseAdd").click(function(){
     $('#bPurChaseAddModal').modal('show');
  });
  $("#bPurChase_save_btn").click(function(){
     $.ajax({  
            url:"add",
            data:$("#bPurChaseAddModal form").serialize(),  
            type:"post",  
            dataType:"json",  
            success:function(data){
               if(data.result){
                 $('#bPurChaseAddModal').modal('hide');
                  window.location.href="list";
                }
            },  
            error:function(data){ 
                console.log(data.responseText);
                console.log("失败");  
            }  
        })  
  });
  $("#bPurChase_update_btn").click(function(){
    console.log($("#bPurChaseUpdateModal form").serialize());
     $.ajax({  
            url:"update",
            data:$("#bPurChaseUpdateModal form").serialize(),  
            type:"post",  
            dataType:"json",  
            success:function(data){
               if(data.result){ 
                 $('#bPurChaseUpdateModal').modal('hide');
                 window.location.href="list";
                }else{
                 alert("删除失败")
                }
            },  
            error:function(){  
                console.log("失败");  
            }  
        })  
  });
 function selAll(b) {
  var i, cbs =$("input[name='cbsel']");
  for(i=0; i<cbs.length; i++)
    cbs[i].checked = b;
 }
 $("#bPurChaseDelete").click(function(){
    var i, arr = new Array();
    var cbs =$("input[name='cbsel']");
     for(i=0; i<cbs.length; i++){
       if(cbs[i].checked) arr.push(cbs[i].value);
    }
    if(arr.length==0){
      window.alert("请选择");
    }else{
    $.post('deletes',{id:arr.join(",")},function(data){
         console.log(data.result);  
         if(data.result){
            window.location.href="list";
         }else{
            alert("删除失败");
            console.log("失败");  
         }
    },'json');
   }
  }); 
</script>
</body>
</html>