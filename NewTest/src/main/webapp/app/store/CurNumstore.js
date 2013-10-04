/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/15/13
 * Time: 9:07 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.store.CurNumstore", {
    extend: 'Ext.data.Store',
    id: 'CurNumstore',
    autoLoad: true,
    fields: [
        'id'
        //{name: 'id', type: 'string'}
    ],
    proxy: {

        type: 'ajax',
        api: {
            read: '/Course/viewcurnum.action'
        },
        //设定读取的格式
        reader: {
            type: 'json',
            //idProperty: 'id',
            root: 'data',
            success: 'success',
            totalProperty: 'total'


        }


    },


    remoteSort: true

});
