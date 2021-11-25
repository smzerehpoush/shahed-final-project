(this["webpackJsonpgis-frontend"]=this["webpackJsonpgis-frontend"]||[]).push([[0],{156:function(e,t,n){},181:function(e,t,n){"use strict";n.r(t);var c=n(0),r=n.n(c),a=n(39),i=n.n(a),s=(n(156),n(50)),o=n(52),j=n(17),l=n(244),d=n(245),b=n(234),h=n(238),u=n(254),x=n(241),O=n(255),m=n(246),p=n(250),g=n(127),f=n.n(g),v=n(251),w=n(249),C=n(132),y=n(248),I=n(97),T=n.n(I),S=n(2),k=Object(c.createContext)(T.a);function L(e){var t=e.children,n=Object(c.useMemo)((function(){var e=T.a.create({baseURL:"http://localhost:4040/api/v1/",headers:{"Content-Type":"application/json"}});return e.interceptors.request.use((function(e){var t=localStorage.getItem("token");return t&&e.headers&&(e.headers.Authorization="Bearer ".concat(t)),e})),e}),[]);return Object(S.jsx)(k.Provider,{value:n,children:t})}function z(){return Object(c.useContext)(k)}var D=Object(C.a)();function N(){var e=z(),t=Object(j.f)(),n=Object(s.useMutation)((function(t){return e.post("/users/login",t)}),{onSuccess:function(e,n,c){void 0!==e.data.token&&(localStorage.setItem("token",e.data.token),t("/",{replace:!0}))}});return Object(S.jsx)(y.a,{theme:D,children:Object(S.jsxs)(w.a,{component:"main",maxWidth:"xs",children:[Object(S.jsx)(b.a,{}),Object(S.jsxs)(p.a,{sx:{marginTop:8,display:"flex",flexDirection:"column",alignItems:"center"},children:[Object(S.jsx)(l.a,{sx:{m:1,bgcolor:"secondary.main"},children:Object(S.jsx)(f.a,{})}),Object(S.jsx)(v.a,{component:"h1",variant:"h5",children:"Log in"}),Object(S.jsxs)(p.a,{component:"form",onSubmit:function(e){e.preventDefault();var t=new FormData(e.currentTarget),c=(t.get("username")||"").toString(),r=(t.get("password")||"").toString();n.mutate({username:c,password:r})},noValidate:!0,sx:{mt:1},children:[Object(S.jsx)(h.a,{margin:"normal",required:!0,fullWidth:!0,id:"username",label:"Username",name:"username",autoComplete:"username",autoFocus:!0}),Object(S.jsx)(h.a,{margin:"normal",required:!0,fullWidth:!0,name:"password",label:"Password",type:"password",id:"password",autoComplete:"current-password"}),Object(S.jsx)(u.a,{control:Object(S.jsx)(x.a,{value:"remember",color:"primary"}),label:"Remember me"}),Object(S.jsx)(d.a,{type:"submit",fullWidth:!0,variant:"contained",sx:{mt:3,mb:2},children:"Log In"}),Object(S.jsxs)(m.a,{container:!0,children:[Object(S.jsx)(m.a,{item:!0,xs:!0,children:Object(S.jsx)(O.a,{href:"#",variant:"body2",children:"Forgot password?"})}),Object(S.jsx)(m.a,{item:!0,children:Object(S.jsx)(O.a,{href:"#",variant:"body2",children:"Don't have an account? Sign Up"})})]})]})]})]})})}var U=n(70),M=n(7),F=[{geo:{lat:-74.0707383,long:40.7117244,height:100},meta:{name:"Tokyo",title:"Hello Tokyo",description:"Tokyo is available here!",pixelSize:10}},{geo:{lat:-72.0707383,long:30.7117244,height:100},meta:{name:"Nowhere",title:"Test location named Nowhere",description:"Nowhere is available here!",pixelSize:20}},{geo:{lat:35.0707383,long:12.7117244,height:100},meta:{name:"Loc1",title:"Test location named Nowhere",description:"Nowhere is available here!",pixelSize:20}},{geo:{lat:72.0707383,long:-30.7117244,height:100},meta:{name:"Loc2",title:"Test location named Nowhere",description:"Nowhere is available here!",pixelSize:20}}];function J(){return Object(S.jsx)(U.d,{fullscreenButton:!0,children:F.map((function(e){var t=M.Cartesian3.fromDegrees(e.geo.lat,e.geo.long,e.geo.height);return Object(S.jsxs)(U.a,{position:t,name:e.meta.name,children:[Object(S.jsx)(U.c,{pixelSize:e.meta.pixelSize}),Object(S.jsxs)(U.b,{children:[Object(S.jsx)("h1",{children:e.meta.title}),Object(S.jsx)("p",{children:e.meta.description})]})]})}))})}var P=n(257),Y=n(261),q=n(260),B=n(256),W=n(258),Z=n(259),H=n(252);function Q(){var e=z(),t=Object(s.useQuery)("users",(function(){return e("/users/",{}).then((function(e){return e.data}))})),n=t.isLoading,c=t.error,r=t.data,a=t.isFetching;return console.log({isLoading:n,error:c,data:r,isFetching:a}),Object(S.jsxs)(p.a,{sx:{padding:1},children:[Object(S.jsx)("h1",{children:"Users:"}),Object(S.jsx)(B.a,{component:H.a,children:Object(S.jsxs)(P.a,{sx:{minWidth:650},children:[Object(S.jsx)(W.a,{children:Object(S.jsxs)(Z.a,{children:[Object(S.jsx)(q.a,{children:"User ID"}),Object(S.jsx)(q.a,{align:"left",children:"Username"})]})}),Object(S.jsx)(Y.a,{children:null===r||void 0===r?void 0:r.users.map((function(e){return Object(S.jsxs)(Z.a,{sx:{"&:last-child td, &:last-child th":{border:0}},children:[Object(S.jsx)(q.a,{component:"th",scope:"row",children:e.id}),Object(S.jsx)(q.a,{align:"left",children:e.username})]},e.id)}))})]})})]})}var R=n(15),A=n(129),E=n.n(A),X=n(128),G=n.n(X),K=n(130),V=n.n(K),_=n(131),$=n.n(_),ee=n(262),te=n(247),ne=n(253),ce=n(242),re=n(263),ae=n(264);function ie(){var e=c.useState(!1),t=Object(R.a)(e,2),n=t[0],r=t[1],a=function(){return r(!n)};return Object(S.jsxs)("div",{children:[Object(S.jsx)(ee.a,{onClick:a,children:Object(S.jsx)(G.a,{})}),Object(S.jsx)(te.a,{anchor:"left",open:n,onClose:a,children:Object(S.jsx)(p.a,{sx:{width:250},onClick:a,onKeyDown:a,children:Object(S.jsxs)(ne.a,{children:[Object(S.jsxs)(ce.a,{button:!0,children:[Object(S.jsx)(re.a,{children:Object(S.jsx)(E.a,{})}),Object(S.jsx)(ae.a,{children:Object(S.jsx)(o.b,{to:"/",children:"Home"})})]}),Object(S.jsxs)(ce.a,{button:!0,children:[Object(S.jsx)(re.a,{children:Object(S.jsx)(V.a,{})}),Object(S.jsx)(ae.a,{children:Object(S.jsx)(o.b,{to:"/login",children:"Login"})})]}),Object(S.jsxs)(ce.a,{button:!0,children:[Object(S.jsx)(re.a,{children:Object(S.jsx)($.a,{})}),Object(S.jsx)(ae.a,{children:Object(S.jsx)(o.b,{to:"/users",children:"Users"})})]})]})})})]})}var se=function(){return Object(S.jsx)(o.a,{children:Object(S.jsxs)(p.a,{sx:{margin:1},children:[Object(S.jsx)(ie,{}),Object(S.jsxs)(j.c,{children:[Object(S.jsx)(j.a,{path:"/login",element:Object(S.jsx)(N,{})}),Object(S.jsx)(j.a,{path:"/",element:Object(S.jsx)(J,{})}),Object(S.jsx)(j.a,{path:"/about",element:Object(S.jsx)("div",{children:"About..."})}),Object(S.jsx)(j.a,{path:"/users",element:Object(S.jsx)(c.Suspense,{fallback:Object(S.jsx)("span",{children:"Loading..."}),children:Object(S.jsx)(Q,{})})})]})]})})};var oe=function(){var e=new s.QueryClient({defaultOptions:{queries:{suspense:!0}}});return Object(S.jsx)(L,{children:Object(S.jsx)(s.QueryClientProvider,{client:e,children:Object(S.jsx)(se,{})})})},je=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,266)).then((function(t){var n=t.getCLS,c=t.getFID,r=t.getFCP,a=t.getLCP,i=t.getTTFB;n(e),c(e),r(e),a(e),i(e)}))};M.Ion.defaultAccessToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiIwYzM1ZTc4Yi01ODkxLTRjNjctYjg4Yy03YzZlOTMwZTJjZTYiLCJpZCI6NzQxMjcsImlhdCI6MTYzNzUwODU5MX0.UDnotJLH9qEoub-CstdHaPC2X1BPEe_bfa6rBMlIKPM",i.a.render(Object(S.jsx)(r.a.StrictMode,{children:Object(S.jsx)(oe,{})}),document.getElementById("root")),je()},7:function(e,t){e.exports=Cesium}},[[181,1,2]]]);
//# sourceMappingURL=main.ac0df288.chunk.js.map