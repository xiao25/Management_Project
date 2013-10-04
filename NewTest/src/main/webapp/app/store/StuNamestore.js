/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/15/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.store.StuNamestore", {
    extend: 'Ext.data.Store',

    id: 'StuNamestore',
    autoLoad: false,
    fields: [
        'stuname'
        //{name: 'id', type: 'string'}
    ],

    listeners: {

        'beforeload': (function (ds) {
            var data=null;
            if(Ext.ComponentQuery.query('Inqumethod')[0]!=undefined){
                data=Ext.encode({'autoContent': Ext.ComponentQuery.query('Inqumethod')[0].getValues().stuname});
            }
            else if(Ext.ComponentQuery.query('inqstuname_form')[0]!=undefined)  {
                data=Ext.encode({'autoContent': Ext.ComponentQuery.query('inqstuname_form')[0].getValues().stuname});

            }
            Ext.apply(
               ds.proxy.extraParams,
                {
                    'query': data

                });


        })
    },
    proxy: {

        type: 'ajax',
        api: {
            read: '/Student/viewstuname.action'
        },
        //设定读取的格式
        reader: {
            type: 'json',
            //idProperty: 'id',
            root: 'data'



        }


    },


    remoteSort: true

});