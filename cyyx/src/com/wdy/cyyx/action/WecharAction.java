package com.wdy.cyyx.action;


public class WecharAction extends BaseAction {

	// HttpServletRequest request;
	// HttpServletResponse response;
	//
	// private String echostr;
	// private String signature;
	// private String timestamp;
	// private String nonce;
	// private String accessId;
	// private String upid;
	// private String uu;
	// private String scene_id;
	// private String scene_str;
	//
	// // 网站域名 需要配置好
	// private final String webUrl = "";// "http://xf.elenjoy.com/";
	// // 默认回复响应 如果业主没设置回复响应 使用defaultaAdmin业主的回复响应 需要配置好
	// private String defaultAdmin = "ystwr";
	//
	// // 存储默认回复的admin
	// private boolean finalDefaultAdmin = false;
	//
	// public String getEchostr() {
	// return echostr;
	// }
	//
	// @Resource
	// private CommanddefaultService commanddefaultService;
	// @Resource
	// private WeixinreplydefaultService weixinreplydefaultService;
	// @Resource
	// private WeixinAccessService weixinAccessService;
	//
	// @Resource
	// private CustomerService customerService;
	//
	// public void setEchostr(String echostr) {
	// this.echostr = echostr;
	// }
	//
	// public String getSignature() {
	// return signature;
	// }
	//
	// public void setSignature(String signature) {
	// this.signature = signature;
	// }
	//
	// public String getTimestamp() {
	// return timestamp;
	// }
	//
	// public void setTimestamp(String timestamp) {
	// this.timestamp = timestamp;
	// }
	//
	// public String getNonce() {
	// return nonce;
	// }
	//
	// public void setNonce(String nonce) {
	// this.nonce = nonce;
	// }
	//
	// @Override
	// public String execute() throws Exception {
	// String result = doPost();
	// return result;
	// }
	//
	// public String doPost() {
	//
	// Enumeration paramNames = getRequest().getParameterNames();
	// while (paramNames.hasMoreElements()) {
	// String paramName = (String) paramNames.nextElement();
	// System.err.println("paramName=" + paramName + "========");
	// }
	//
	// // 从请求中获取accessId
	// try {
	//
	// System.err.println("--------------" + accessId);
	// setSession("accessId", accessId);
	// // 根据accessId从缓存中拿到接入数据
	// // WeixinAccess wxAccess = (WeixinAccess)
	// // ContextMgr.global.getContextByPath("weixin。"+accessId).getData();
	// // 从请求中获取绑定信息
	// ActionContext ac = ActionContext.getContext();
	// System.out.println("-----------ac:" + ac);
	// request = (HttpServletRequest) ac
	// .get(ServletActionContext.HTTP_REQUEST);
	// System.out.println("-----------request:");
	// response = (HttpServletResponse) ac
	// .get(ServletActionContext.HTTP_RESPONSE);
	// System.out.println("-----------response:");
	// request.setCharacterEncoding("utf-8");
	// System.out.println("-----------requestSetEncode:");
	// response.setCharacterEncoding("utf-8");
	// System.out.println("-----------responseSetEncode:");
	// PrintWriter out = response.getWriter();
	//
	// System.out.println("echostr:" + echostr);
	//
	// System.out.println("signature:" + signature);
	// System.out.println("timestamp:" + timestamp);
	// System.out.println("nonce:" + nonce);
	// System.out.println("accessId:" + accessId);
	// // 判断是否是微信绑定
	// String echosterRes = this.doEchostr(echostr, signature, timestamp,
	// nonce, accessId);
	// System.out.println("echosterRes:" + echosterRes);
	// if (!echosterRes.equals("true")) {
	// out.print(echosterRes);
	// return null;
	// }
	//
	// // 解析威信内容
	// String postStr = Weixinoper.Instance().readStreamParameter(
	// request.getInputStream());
	//
	// System.err.println("postStr=" + postStr);
	//
	// String resultStr = this.doxml(postStr, accessId);
	//
	// System.err.println("postStr=" + postStr);
	//
	// if (resultStr.equals("false")) {
	// return "no xml result";
	// } else {
	// out.print(resultStr);
	// return null;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "error";
	// }
	//
	// }
	//
	// // 判断是否是微信绑定的方法
	// public String doEchostr(String echostr, String signature, String
	// timestamp,
	// String nonce, String accessId) throws ServletException {
	//
	// try {
	// System.err.println("weixinAccessService===" + weixinAccessService);
	// System.err.println("accessId=" + accessId);
	// WeixinAccess wxAccess = weixinAccessService.get(accessId);
	// if (wxAccess == null) {
	// return "error:not this accessId";
	// }
	// System.out.println("wxAccess:" + wxAccess);
	// System.out.println("wxAccess.getToken:" + wxAccess.getToken());
	// Weixinoper.TOKEN = wxAccess.getToken();
	// // WeiXinOper.Instance().
	// if (null != echostr && !echostr.isEmpty()) {
	// // 还没有对接 所以需要对接！ 在这里操作
	// if (Weixinoper.Instance().checkSignature(signature, timestamp,
	// nonce)) {
	// // 改成已对接
	// System.out.println("return echostr:" + echostr);
	// return echostr;
	// } else {
	// System.out.println("return checkSignature:error!");
	// return "error";
	// }
	// } else {
	// System.out.println("echostr ");
	// }
	// return "true";
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "error";
	// }
	// }
	//
	// // 接卸Xml
	// @SuppressWarnings({ "deprecation", "unused" })
	// public String doxml(String postStr, String accessId) throws Exception {
	// if (null == postStr || postStr.isEmpty()) {
	// throw new RuntimeException("postStr is null");
	// }
	//
	// HashMap<String, String> document = Weixinoper.Instance().parserXml(
	// postStr);
	// if (null == document) {
	// return "false";
	// }
	//
	// String fromUsername = document.get("FromUserName");
	// String event = document.get("Event");
	// System.err.println("event============="+event);
	// // 判断事件
	// //#保存用户####################################
	// if (!StringUtils.isEmpty(event)) {
	// if (event.equals("subscribe")||event.equals("SCAN")) {
	// String eventKey = document.get("EventKey");
	// if(eventKey == null){
	// eventKey = "default";
	// }
	// // 获取ID
	// // if (!StringUtils.isEmpty(eventKey)) {
	// String upid = null;
	// if(event.equals("subscribe")){
	// if (eventKey.indexOf("qrscene_") >= 0) {
	// upid = eventKey.replace("qrscene_", "");
	// }
	// }else if(event.equals("SCAN")){
	// upid = eventKey;
	// }
	// // if (!StringUtils.isEmpty(upid)) {
	//
	// System.err.println("--------111111111111111111111");
	// System.err.println("=============----==0+++++===event==="+event);
	// customerService.saveorGetCustomer(fromUsername, event, null, accessId,
	// upid);
	// System.err.println("--------222222222222222222222222");
	// // }
	//
	// // }
	//
	// }
	//
	// }
	// //#保存用户结束####################################
	// String toUsername = document.get("ToUserName");
	// String keyword = document.get("Content");
	// String MsgType = document.get("MsgType");
	// String PicUrl = document.get("PicUrl");
	// System.out.println("---MsgType:" + MsgType);
	// System.out.println("---PicUrl:" + PicUrl);
	// WeixinAccess wxAccess = weixinAccessService.get(accessId);
	// // 判断是否需要状态处理
	// String statusStr = "register";
	// // if (wxAccess.getStatusProcess() != null
	// // && !"comsumer".equals(wxAccess.getStatusProcess())) {
	// // statusStr = WeiXinOper.Instance().getUserSatus(fromUsername,
	// // wxAccess.getStatusProcess());
	// // } else {
	// // statusStr = "_DEFAULT";
	// // }
	//
	// // String keyword1 = new String(keyword.getBytes("ISO8859-1"),"UTF-8");
	// // System.err.println(keyword1);
	// if (keyword != null && keyword != "") {
	// keyword = new String(keyword.getBytes("GBK"), "UTF-8");
	// }
	// // String keyword3 = new String(keyword.getBytes("UTF8"),"GBK");
	// // System.err.println("3="+keyword3);
	// //
	// //
	// // String keyword4 = new String(keyword.getBytes("GB2312"),"UTF-8");
	// // System.err.println("4="+keyword4);
	// // 把fromUsername、toUsername、keyword、statusStr、dataOwner放入map
	// Map<String, String> resp = new HashMap<String, String>();
	// resp.put("FromUserName", fromUsername);
	// resp.put("ToUserName", toUsername);
	// resp.put("Content", keyword);
	// resp.put("statusStr", statusStr);
	// resp.put("dataOwner", wxAccess.getDataOwner());
	//
	// // 从接入数据得到基础数据别名
	// String baseAlias = wxAccess.getBaseDataAlias();
	// String defaultAlias = wxAccess.getDefaultDataAlias();
	//
	// System.err.println("baseAlias=" + baseAlias
	// + "            defaultAlias=" + defaultAlias);
	// // 根据别名得到dataOwner的Breeze对象
	//
	// System.err.println("statusSt=" + statusStr);
	// // 获取用户状态
	// // 注释时间2014年3月20日 15:12:41
	// // BreezeContext statusContext = ContextMgr.global
	// // .getContextByPath("weixin." + baseAlias + "."
	// // + wxAccess.getDataOwner() + "." + statusStr);
	// String statusContext = null;
	//
	// if (statusContext == null) {
	// // 注释时间2014年3月20日 15:12:41
	// // System.out.println("调用默认用户的状态");
	// // statusContext =
	// // ContextMgr.global.getContext("weixin").getContext(
	// // defaultAlias).getContext("_default").getContext(statusStr);
	// }
	// // System.err.println("ContextMgr.global="
	// // + ContextMgr.global.getContext("weixin").getContext(
	// // defaultAlias).toString());
	//
	// // 根据状态获取命令
	// // 注释时间2014年3月20日 15:12:41
	// // BusinessWeixinStruct wxStruct = null;
	// // if (statusContext.getContext(wxAccess.getDataOwner() + "." + keyword)
	// // != null) {
	// // wxStruct = (BusinessWeixinStruct) statusContext.getContext(
	// // wxAccess.getDataOwner() + "." + keyword).getData();
	// // } else {
	// // wxStruct = (BusinessWeixinStruct) statusContext.getContext(
	// // wxAccess.getDataOwner() + "._default").getData();
	// // }
	// String time = new Date().getTime() + "";
	// // 回复内容为文本类型
	//
	// String vers = "e38";
	//
	// String resultStr = "";
	// String projectPath = webUrl;
	// // 林浩旋 获取业主自己的默认请求 2014年3月20日 16:32:19
	// // 如果没有注册 找注册 找不到注册 找默认 先不要判断是否注册
	// Commanddefault commandDefault = null;
	// // if(bussinessownerService.get("weixinid", fromUsername, true)==null)
	// // {
	// // commandDefault = commanddefaultService.get("command", "register",
	// // wxAccess.getDataOwner(), true);
	// // }
	// // //如果注册好的 找key相关回复
	// // else
	// // {
	// // commandDefault = commanddefaultService.get("command", keyword,
	// // wxAccess.getDataOwner(), true);
	//
	// // }
	// // 回复公司的 各个公司回复各个公司的 林浩旋 2014年4月24日 17:39:28
	// // 查出访问的所属公司
	// // Bussinessowner guest = bussinessownerService.get(wxAccess.getBsid());
	// // SystemClass guest = systemClassService.get(wxAccess.getAccessId());
	// // System.out.println("guest:" + guest);
	// // if (wxAccess != null) {
	// // // 如果是云商通就用新规则 不是就用E点通 以前的规则
	// // if (wxAccess.getStatusProcess().equals("comsumer")) {
	// // finalDefaultAdmin = true;
	// // // 根据特定规则
	// // String dataOwner_sys = "ystwr_" + guest.getSys();
	// // System.out.println("dataOwner_sys:" + dataOwner_sys);
	// // if(keyword!=null)
	// // {
	// // commandDefault = commanddefaultService.get("command", keyword,
	// // dataOwner_sys, false);
	// // }
	// // //使用默认
	// // if(commandDefault==null)
	// // {
	// // commandDefault = commanddefaultService.get("command", "default",
	// // dataOwner_sys, false);
	// // }
	// // }
	// // }
	//
	// System.err.println("keyword---------------" + keyword);
	//
	// // E点通 bussiness版 keyword的回复
	// if (commandDefault == null) {
	//
	// System.err.println("accessId=====" + accessId);
	// // 版本1.0 的回复
	// // commandDefault = commanddefaultService.get("command", keyword,
	// // wxAccess.getDataOwner(), true);
	//
	// // 版本2.0 的回复 2014年10月9日 11:23:29 林浩旋 现在的字段用使用多个关键字来模糊查询
	// // Bussinessowner user =
	// // bussinessownerService.get(wxAccess.getBsid());
	// QueryParam param = new QueryParam(1).add("systemClass.cid",
	// Integer.parseInt(accessId));
	// List<Commanddefault> comlist = commanddefaultService.getLikeList(
	// "command", "%" + keyword + "%", null, param, 0, 0, "cid",
	// "desc", false);
	//
	// System.err.println("111===================" + comlist.size());
	// if (comlist != null && comlist.size() > 0) {
	// commandDefault = comlist.get(0);
	// }
	// }
	// // 都找不到就找默认
	// if (commandDefault == null) {
	//
	// commandDefault = commanddefaultService.get(
	// new QueryParam(2).add("systemClass.cid",
	// Integer.parseInt(accessId)).add("command",
	// "default"), false);
	// //
	// // commandDefault = commanddefaultService.get("command", "default",
	// // wxAccess.getDataOwner(), true);
	// }
	//
	// // 暂时不查自己的 都查系统默认的 回复 以后要做白金版自定义的 使用上一行代码查询自己的回复 author林浩旋
	// // Commanddefault commandDefault = null;
	// // 获取默认回复 2014年3月20日 16:32:27
	// try {
	// if (commandDefault == null) {
	// // 使用了默认系统回复
	// finalDefaultAdmin = true;
	// System.out.println("shiyong moren system");
	// // 服务版本
	// if (vers.equals("e38") || vers.equals("business")) {
	// // //找不到用户 就回复 register 找不到register 就还是找default
	// // 不需要判断是否注册暂时注释掉
	// // if(bussinessownerService.get("weixinid", fromUsername,
	// // true)==null)
	// // {
	// // commandDefault = commanddefaultService.get("command",
	// // "register", defaultAdmin, false);
	// // }
	// // else
	// // {
	// // commandDefault = commanddefaultService.get("command",
	// // keyword, defaultAdmin, false);
	// commandDefault = commanddefaultService.get(
	// new QueryParam(2).add("dataOwner", defaultAdmin)
	// .add("command", keyword), false);
	// if (commandDefault == null) {
	// // 如果回复找不到 系统尝试 寻找 default
	//
	// commandDefault = commanddefaultService.get(
	// new QueryParam(2)
	// .add("dataOwner", defaultAdmin).add(
	// "command", "default"), false);
	//
	// // commandDefault = commanddefaultService.get("command",
	// // "default", defaultAdmin, false);
	// if (commandDefault == null) {
	// System.err.println("system no results!");
	// return "error 321";
	// }
	// }
	// // }
	// }
	// // 营销版本
	// else {
	// // 找不到用户 就回复 register 找不到register 就还是找default 不需要判断是否注册暂时注释掉
	// // if(customerServivce.get("weixinid", fromUsername,
	// // true)==null)
	// // {
	// // commandDefault = commanddefaultService.get("command",
	// // "register", defaultAdmin, false);
	// // }
	// // else
	// // {
	// commandDefault = commanddefaultService.get(
	// new QueryParam(2).add("dataOwner", defaultAdmin)
	// .add("command", keyword), false);
	// // commandDefault = commanddefaultService.get("command",
	// // keyword, defaultAdmin, false);
	// if (commandDefault == null) {
	// // 如果回复找不到 系统尝试 寻找 default
	// commandDefault = commanddefaultService.get(
	// new QueryParam(2)
	// .add("dataOwner", defaultAdmin).add(
	// "command", "default"), false);
	// // commandDefault = commanddefaultService.get("command",
	// // "default", defaultAdmin, false);
	// if (commandDefault == null) {
	// System.err.println("system no results!");
	// return "error 321";
	// }
	// }
	// // }
	// }
	//
	// }
	// } catch (Exception e) {
	// System.out.println(e);
	// return "error commandDefault";
	// }
	//
	// // Weixinreplydefault weixinreplydefault =
	// // weixinreplydefaultService.get(
	// // "cid", commandDefault.getReplycid(), true);
	//
	// Weixinreplydefault weixinreplydefault = weixinreplydefaultService
	// .get(commandDefault.getReplycid());
	//
	// // 林浩旋 2014年3月24日 16:26:37 如果 欢迎语 加上自己业主名称
	// String bname = "";
	// // xml 回复标题
	// String reTitle = weixinreplydefault.getTitle();
	// // xml 回复内容
	// String reDesc = weixinreplydefault.getRedesc();
	// SystemClass systemClass = null;
	// systemClass = systemClassService.get(Integer.parseInt(wxAccess
	// .getAccessId()));
	// // 设置该会员已绑定
	// // if (systemClass != null) {
	// // if (bussinessowner.getIsopen() == null
	// // || !bussinessowner.getIsopen().equals("1")) {
	// // bussinessowner.setIsopen("1");
	// // bussinessownerService.update(bussinessowner);
	// // }
	// // }
	// // 查出自己的公众帐号
	// bname = systemClass.getWeixinname();
	// // 查出自己的电话
	// String btel = systemClass.getLinkphone();
	// // 查出自己的公众号名称
	// String weixinname = systemClass.getWeixinname();
	// // + 公众名称
	//
	// if (systemClass != null) {
	// if (bname == null) {
	// bname = "-";
	// }
	// if (weixinreplydefault.getType().equals("0")) {
	// if (reDesc.indexOf("{name}") > 0) {
	// reDesc = reDesc.replace("{name}", bname);
	// }
	// } else {
	// if (reTitle != null && reTitle.indexOf("{name}") > 0) {
	// reTitle = reTitle.replace("{name}", bname);
	// }
	// }
	// }
	//
	// // 判断是否是0的类型 0为文本 1为单图文 2为多图文 林浩旋 2014年3月20日 16:34:41
	// if (weixinreplydefault.getType().toString().equals("0")) {
	// // 彭先灿需求 author 林浩旋 文本 字符串特殊处理 找到key 替换
	// if (reDesc.indexOf("{key}") > 0) {
	// String keySet = "";
	// // 如果 公众帐号设置为空，
	// if (bname == null || bname.equals("")) {
	// reDesc = reDesc.replace("{key}", "非常感谢您的关注");
	// }
	// // 不为空
	// else {
	// keySet = "欢迎您对" + bname + "的支持";
	// reDesc = reDesc.replace("{key}", keySet);
	// }
	// }
	// // 改成公众帐号名称
	// if (reDesc.indexOf("{key1}") > 0) {
	// // 如果 公众帐号设置为空，
	// if (weixinname == null || weixinname.equals("")) {
	// reDesc = reDesc.replace("{key1}", "");
	// }
	// // 不为空
	// else {
	// reDesc = reDesc.replace("{key1}", weixinname);
	// }
	// }
	// // 如果tel存在 就替换成数据库里的电话
	// if (reDesc.indexOf("{tel}") > 0) {
	// // 电话不存在 替换成空字符串
	// if (btel == null || btel.equals("")) {
	// reDesc = reDesc.replace("{tel}", "");
	// } else {
	// reDesc = reDesc.replace("{tel}", btel);
	// }
	// }
	// resultStr += "<xml>";
	// resultStr += "<ToUserName><![CDATA[" + fromUsername
	// + "]]></ToUserName>";
	// resultStr += "<FromUserName><![CDATA[" + toUsername
	// + "]]></FromUserName>";
	// resultStr += "<CreateTime>" + time + "</CreateTime>";
	// resultStr += "<MsgType><![CDATA[text]]></MsgType>";
	// resultStr += "<Content><![CDATA[" + reDesc + "]]></Content>";
	// resultStr += "</xml>>";
	// } else if (weixinreplydefault.getType().toString().equals("2")) {
	// resultStr += "<xml>";
	// resultStr += "<ToUserName><![CDATA[" + fromUsername
	// + "]]></ToUserName>";
	// resultStr += "<FromUserName><![CDATA[" + toUsername
	// + "]]></FromUserName>";
	// resultStr += "<CreateTime>" + time + "</CreateTime>";
	// resultStr += "<MsgType><![CDATA[news]]></MsgType>";
	//
	// JSONArray jsCount = JSONArray.fromObject(weixinreplydefault
	// .getPiclist());
	//
	// if (jsCount != null) {
	// resultStr += "<ArticleCount>" + jsCount.size()
	// + "</ArticleCount>";
	// resultStr += "<Articles>";
	// for (int i = 0; i < jsCount.size(); i++) {
	// JSONObject picList = JSONObject.fromObject(jsCount.get(i)
	// .toString());
	// resultStr += " <item>";
	// String picname = "";
	// if (picList.get("picname") != null) {
	// picname = picList.get("picname").toString();
	// }
	// // + 公众名称
	// if (picname.indexOf("{name}") > 0) {
	// picname = picname.replace("{name}", bname);
	// }
	//
	// String picUrl = "";
	// if (picList.get("picurl") != null) {
	// picUrl = picList.get("picurl").toString();
	// }
	//
	// String gourl = "";
	// if (picList.get("gourl") != null) {
	// gourl = picList.get("gourl").toString();
	// // 如果是系统 默认回复 那么将这里访问URL的{id} 改变成 业主cid
	// if (gourl.indexOf("{id}") > 0) {
	// // System.out.println("bussinessowner.getCid:"
	// // + bussinessowner.getCid());
	// // gourl = gourl.replace("{id}",
	// // bussinessowner.getCid() + "");
	// }
	//
	// System.err
	// .println("=-========222222===================="
	// + gourl);
	//
	// System.err.println("gourl.indexOf(/page/xf) >= 0"
	// + gourl.indexOf("/page/xf"));
	// if (gourl.indexOf("/page/xf") >= 0) {
	//
	// System.err
	// .println("=-============================");
	// // int xg = gourl.lastIndexOf("/");
	// // int length = gourl.length();
	// // gourl = gourl.substring(0, xg)
	// // + wxAccess.getDataOwner()
	// // + gourl.substring(xg, length);
	// gourl = gourl.replace("/page/xf",
	// "/e/" + wxAccess.getDataOwner());
	// }
	// // url = wxStruct.getUrl();
	// // 没有参数的时候
	// if (gourl.indexOf("?") < 0) {
	// gourl += "?";
	// } else {
	// gourl += "&";
	// }
	//
	// // url += "weixinid=${FromUserName}&marketingId="
	// // + wxAccess.getDataOwner() + "&vers=" + vers;
	// // gourl = gourl +
	// // "weixinid=${FromUserName}&marketingId="
	// // + wxAccess.getDataOwner() + "&vers=" + vers;
	//
	// gourl = gourl + "weixinid=${FromUserName}";
	//
	// // gourl = url
	// // +
	// // "/weixin/redirect.jsp?weixinid=${FromUserName}&marketingId="
	// // + wxAccess.getDataOwner() + "&vers=" + vers
	// // + "&url=" + URLEncoder.encode(gourl);
	// }
	// resultStr += " <Title><![CDATA[" + picname + "]]></Title> ";
	// resultStr += " <Description><![CDATA[暂无]]></Description>";
	// resultStr += " <PicUrl><![CDATA[" + picUrl + "]]></PicUrl>";
	// resultStr += " <Url><![CDATA[" + gourl + "]]></Url>";
	// resultStr += " </item>";
	// }
	// resultStr += " </Articles>";
	// }
	//
	// resultStr += "</xml>";
	// } else {
	// resultStr += "<xml>";
	// resultStr += "<ToUserName><![CDATA[" + fromUsername
	// + "]]></ToUserName>";
	// resultStr += "<FromUserName><![CDATA[" + toUsername
	// + "]]></FromUserName>";
	// resultStr += "<CreateTime>" + time + "</CreateTime>";
	// resultStr += "<MsgType><![CDATA[news]]></MsgType>";
	//
	// String url = weixinreplydefault.getUrl();
	//
	// // 如果是系统 默认回复 那么将这里访问URL的{id} 改变成 业主cid
	// if (url != null) {
	// if (url.indexOf("{id}") > 0) {
	// // url = url.replace("{id}", bussinessowner.getCid() + "");
	// }
	// // 没有参数的时候
	// if (url.indexOf("?") < 0) {
	// url += "?";
	// } else {
	// url += "&";
	// }
	//
	// }
	//
	// // int xg = url.lastIndexOf("/");
	// // int length = url.length();
	// // url = url.substring(0, xg) + wxAccess.getDataOwner()
	// // + url.substring(xg, length);
	// // url = url.replace("/page/xf", "/e/");
	//
	// url += "weixinid=${FromUserName}";
	//
	// // url += "weixinid=${FromUserName}&vers=" + vers;
	// // url +=
	// // "/weixin/redirect.jsp?weixinid=${FromUserName}&marketingId="
	// // + wxAccess.getDataOwner() + "&vers=" + vers + "&url="
	// // + URLEncoder.encode(wxStruct.getUrl());
	// resultStr += "<ArticleCount>1</ArticleCount>";
	// resultStr += "<Articles>";
	// resultStr += " <item>";
	// resultStr += " <Title><![CDATA[" + reTitle + "]]></Title> ";
	// resultStr += " <Description><![CDATA["
	// + weixinreplydefault.getRedesc() + "]]></Description>";
	// resultStr += " <PicUrl><![CDATA[" + weixinreplydefault.getImage()
	// + "]]></PicUrl>";
	// resultStr += " <Url><![CDATA[" + url + "]]></Url>";
	// resultStr += " </item>";
	// resultStr += " </Articles>";
	//
	// resultStr += "</xml>";
	// }
	//
	// Iterator<String> iter = resp.keySet().iterator();
	// while (iter.hasNext()) {
	// String key = iter.next();
	// String val = resp.get(key);
	// resultStr = str_replace(resultStr, "${" + key + "}", val);
	// }
	// return resultStr;
	// }
	//
	// public static String str_replace(String con, String tag, String rep) {
	// int j = 0;
	// int i = 0;
	//
	// String RETU = "";
	// String temp = con;
	// int tagc = tag.length();
	// while (i < con.length()) {
	// if (con.substring(i).startsWith(tag)) {
	// temp = con.substring(j, i) + rep;
	// RETU += temp;
	// i += tagc;
	// j = i;
	// } else {
	// i += 1;
	// }
	// }
	// RETU += con.substring(j);
	// return RETU;
	// }
	//
	// public String getAccessId() {
	// return accessId;
	// }
	//
	// public void setAccessId(String accessId) {
	// this.accessId = accessId;
	// }
	//
	// public String getUpid() {
	// return upid;
	// }
	//
	// public void setUpid(String upid) {
	// this.upid = upid;
	// }
	//
	// public String getUu() {
	// return uu;
	// }
	//
	// public void setUu(String uu) {
	// this.uu = uu;
	// }
	//
	// public String getScene_id() {
	// return scene_id;
	// }
	//
	// public void setScene_id(String scene_id) {
	// this.scene_id = scene_id;
	// }

}
