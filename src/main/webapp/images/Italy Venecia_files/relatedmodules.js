(window.webpackJsonp=window.webpackJsonp||[]).push([["modules/relatedmodules"],{"207d4364e4b5a66ba09b":function(e,t,i){"use strict";(function(e){t.a=e.Collection.extend({endpoint:"ajax/related"})}).call(this,i("292bef011bf0a540c727"))},"5c4508f6ca32cdacdbb2":function(e,s,c){"use strict";c.r(s),function(e,l){var t=c("7ec90be294f8945e7663"),i=c("d46c288b6d4387f2b7de"),d=c("891a19eb7d3552f95f46"),a=c("abfbe0c0349d83b0558c"),n=c("207d4364e4b5a66ba09b"),o=c("654adc4d2d3e5dbaee18");s.default=e.View.extend({el:"body",initialize:function(){this.setVariables(),this.setListeners(),this.collectRelatedIds()},setVariables:function(){this.overrideDefaults({itemModel:i.a.prototype.ModelTemplate,itemView:i.a,moduleTemplate:"#related-module-template",mediaLoader:null}),this.logger=new d.a("RelatedModules"),this.collection=new n.a([],{model:this.itemModel}),this.mediaLoader=Object(o.c)(this.mediaLoader,a.default),this.contentId=t.a.getValue("content.id"),this.$content=l(".content-container"),this.$relatedModules=this.$content.find("[data-embed=related]"),this.relatedIdList=[]},setListeners:function(){this.collection.on("sync",this.handleSync.bind(this))},handleSync:function(){var a=this.itemView;this.logger.log("Sync",arguments),this.collection.each(function(e){var t=l(new a({model:e,templateSelector:this.moduleTemplate}).render().el),i=e.getAttributeFromData("id"),d=this.$content.find("[data-related-id="+i+"]");d.length&&d.replaceWith(t)}.bind(this))},fetchModules:function(){return this.contentId&&this.relatedIdList.length?(this.collection.fetch({data:{id:this.relatedIdList.join(",")}}).fail(this.handleFetchError.bind(this)),!0):(this.logger.log("No modules to load."),!1)},handleFetchError:function(){this.logger.error("Error fetching related modules."),this.$relatedModules.remove()},collectRelatedIds:function(){var i=[];this.$relatedModules.each(function(){var e=l(this),t=e.data("related-id")?e.data("related-id"):"";i.push(t)}),this.relatedIdList=i}})}.call(this,c("292bef011bf0a540c727"),c("4124695a4a0df23fd56c"))}}]);
//# sourceMappingURL=relatedmodules.5eb7c26.js.map