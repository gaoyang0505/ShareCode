// Statistics.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include "Statistics.h"
#include "MainFrm.h"
#include "MenuAll.h"


#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CStatistics

IMPLEMENT_DYNCREATE(CStatistics, CFormView)

CStatistics::CStatistics()
	: CFormView(CStatistics::IDD)
{
	//{{AFX_DATA_INIT(CStatistics)
	m_strResult = _T("");
	m_strHave = _T("");
	m_strOut = _T("");
	//}}AFX_DATA_INIT
}

CStatistics::~CStatistics()
{
}

void CStatistics::DoDataExchange(CDataExchange* pDX)
{
	CFormView::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CStatistics)
	DDX_Control(pDX, IDC_LIST1, m_ctrlList2);
	DDX_Control(pDX, IDC_DATETIMEPICKER2, m_timeEndN);
	DDX_Control(pDX, IDC_DATETIMEPICKER1, m_timeStartN);
	DDX_Text(pDX, IDC_EDIT3, m_strResult);
	DDX_Text(pDX, IDC_EDIT2, m_strHave);
	DDX_Text(pDX, IDC_EDIT1, m_strOut);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CStatistics, CFormView)
	//{{AFX_MSG_MAP(CStatistics)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_BN_CLICKED(IDC_BUTTON2, OnButton2)
	ON_BN_CLICKED(IDC_BUTTON3, OnButton3)
	ON_WM_CTLCOLOR()
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CStatistics diagnostics

#ifdef _DEBUG
void CStatistics::AssertValid() const
{
	CFormView::AssertValid();
}

void CStatistics::Dump(CDumpContext& dc) const
{
	CFormView::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CStatistics message handlers

CString CStatistics::strVARIANT(const COleVariant& var)
{
    CString strRet;

    switch(var.vt)
    {
    case VT_EMPTY:
    case VT_NULL:
        strRet=_T("NULL");
        break;
    case VT_I2:
        strRet.Format(_T("%hd"),V_I2(&var));
        break;
    case VT_I4:
        strRet.Format(_T("%d"),V_I4(&var));
        break;
    case VT_R4:
        strRet.Format(_T("%e"),(double)V_R4(&var));
        break;
    case VT_R8:
        strRet.Format(_T("%e"),V_R8(&var));
        break;
    case VT_CY:
        strRet=COleCurrency(var).Format();
        break;
    case VT_DATE:
        strRet=COleDateTime(var).Format(_T("%m%d%y"));
        break;
    case VT_BSTR:
        strRet=V_BSTRT(&var);
        break;
    case VT_DISPATCH:
        strRet=_T("VT_DISPATCH");
        break;
    case VT_ERROR:
        strRet=_T("VT_ERROR");
        break;
    case VT_BOOL:
        //return strBOOL(V_BOOL(&var));
    case VT_VARIANT:
        strRet=_T("VT_VARIANT");
        break;
    case VT_UNKNOWN:
        strRet=_T("VT_UNKNOWN");
        break;
    case VT_I1:
        strRet=_T("VT_I1");
        break;
    case VT_UI1:
        strRet.Format(_T("0x%02hX"),(unsigned short)V_UI1(&var));
        break;
    case VT_UI2:
        strRet=_T("VT_UI2");
        break;
    case VT_UI4:
        strRet=_T("VT_UI4");
        break;
    case VT_I8:
        strRet=_T("VT_I8");
        break;
    case VT_UI8:
        strRet=_T("VT_UI8");
        break;
    case VT_INT:
        strRet=_T("VT_INT");
        break;
    case VT_UINT:
        strRet=_T("VT_UINT");
        break;
    case VT_VOID:
        strRet=_T("VT_VOID");
        break;
    case VT_HRESULT:
        strRet=_T("VT_HRESULT");
        break;
    case VT_PTR:
        strRet=_T("VT_PTR");
        break;
    case VT_SAFEARRAY:
        strRet=_T("VT_SAFEARRAY");
        break;
    case VT_CARRAY:
        strRet=_T("VT_CARRAY");
        break;
    case VT_USERDEFINED:
        strRet=_T("VT_USERDEFINED");
        break;
    case VT_LPSTR:
        strRet=_T("VT_LPSTR");
        break;
    case VT_LPWSTR:
        strRet=_T("VT_LPWSTR");
        break;
    case VT_FILETIME:
        strRet=_T("VT_FILETIME");
        break;
    case VT_BLOB:
        strRet=_T("VT_BLOB");
        break;
    case VT_STREAM:
        strRet=_T("VT_STREAM");
        break;
    case VT_STORAGE:
        strRet=_T("VT_STORAGE");
        break;
    case VT_STREAMED_OBJECT:
        strRet=_T("VT_STREAMED_OBJECT");
        break;
    case VT_STORED_OBJECT:
        strRet=_T("VT_STORED_OBJECT");
        break;
    case VT_BLOB_OBJECT:
        strRet=_T("VT_BLOB_OBJECT");
        break;
    case VT_CF:
        strRet=_T("VT_CF");
        break;
    case VT_CLSID:
        strRet=_T("VT_CLSID");
        break;
	}
	
	WORD vt=var.vt;
	
	if(vt&VT_ARRAY)
	{
		vt=vt&~VT_ARRAY;
		strRet=_T("Array of");
	}
	
	if(vt&VT_BYREF)
	{
		vt=vt&~VT_BYREF;
		strRet+=_T("Pointer to");
	}

	if(vt!=var.vt)
	{	
		switch(vt)
		{
		case VT_EMPTY:
		    strRet+=_T("VT_EMPTY");
		    break;
		case VT_NULL:
		  strRet+=_T("VT_NULL");
	        break;
		case VT_I2:
			strRet+=_T("VT_I2");
			break;
		case VT_I4:
			strRet+=_T("VT_I4");
			break;
		case VT_R4:
        strRet+=_T("VT_R4");
        break;
    case VT_R8:
        strRet+=_T("VT_r8");
        break;
    case VT_CY:
        strRet+=_T("VT_CY");
        break;
    case VT_DATE:
        strRet+=_T("VT_DATE");
        break;
    case VT_BSTR:
        strRet+=_T("VT_BSTR");
        break;
    case VT_DISPATCH:
        strRet+=_T("VT_DISPATCH");
        break;
    case VT_ERROR:
        strRet+=_T("VT_ERROR");
        break;
    case VT_BOOL:
        strRet+=_T("VT_BOOL");
        break;
    case VT_VARIANT:
        strRet+=_T("VT_VARIANT");
        break;
    case VT_UNKNOWN:
        strRet+=_T("VT_UNKNOWN");
        break;
    case VT_I1:
        strRet+=_T("VT_I1");
        break;
    case VT_UI1:
        strRet+=_T("VT_UI1");
        break;
    case VT_UI2:
        strRet+=_T("VT_UI2");
        break;
    case VT_UI4:
        strRet+=_T("VT_UI4");
        break;
    case VT_I8:
        strRet+=_T("VT_I8");
        break;
    case VT_UI8:
        strRet+=_T("VT_UI8");
        break;
    case VT_INT:
        strRet+=_T("VT_INT");
        break;
    case VT_UINT:
        strRet+=_T("VT_UINT");
        break;
    case VT_VOID:
        strRet+=_T("VT_VOID");
        break;
    case VT_HRESULT:
        strRet+=_T("VT_HRESULT");
        break;
    case VT_PTR:
        strRet+=_T("VT_PTR");
        break;
    case VT_SAFEARRAY:
        strRet+=_T("VT_SAFEARRAY");
        break;
    case VT_CARRAY:
        strRet+=_T("VT_CARRAY");
        break;
    case VT_USERDEFINED:
        strRet+=_T("VT_USERDEFINED");
        break;
    case VT_LPSTR:
        strRet+=_T("VT_LPSTR");
        break;
    case VT_LPWSTR:
        strRet+=_T("VT_LPWSTR");
        break;
    case VT_FILETIME:
        strRet+=_T("VT_FILETIME");
        break;
    case VT_BLOB:
        strRet+=_T("VT_BLOB");
        break;
    case VT_STREAM:
        strRet+=_T("VT_STREAM");
        break;
    case VT_STORAGE:
        strRet+=_T("VT_STORAGE");
        break;
    case VT_STREAMED_OBJECT:
        strRet+=_T("VT_STREAMED_OBJECT");
        break;
    case VT_STORED_OBJECT:
        strRet+=_T("VT_STORED_OBJECT");
        break;
    case VT_BLOB_OBJECT:
        strRet+=_T("VT_BLOB_OBJECT");
        break;
    case VT_CF:
        strRet+=_T("VT_CF");
        break;
    case VT_CLSID:
        strRet+=_T("VT_CLSID");
        break;
		}
	}

	return strRet;
}

void CStatistics::OnButton1() 
{
		// 统计



	CWnd* pWnd;
	pWnd=GetDlgItem(IDC_BUTTON3);
	pWnd->EnableWindow(true);


	if(!m_pDatabase->IsOpen()) return;
	if(!m_pRecordset)		   return;
	if(m_pRecordset->IsOpen()) m_pRecordset->Close();
	
	UpdateData(true);
	
//	m_ctrList1.DeleteAllItems();
	CTime tm1;
	CString Date1;
	m_timeStartN.GetTime(tm1);//m_time为你的时间选择器的CTime类型的变量获取时间到tm中
	Date1=tm1.Format("%Y-%m-%d");//转化成CString类型
	CTime tm2;
	CString Date2;
	m_timeEndN.GetTime(tm2);//m_time为你的时间选择器的CTime类型的变量获取时间到tm中
	Date2=tm2.Format("%Y-%m-%d");//转化成CString类型
	CString strSelect;
	strSelect.Format("SELECT 金额 FROM student_info_table WHERE 日期判 between #%s# and #%s# and 姓名='%s' ",
		Date1,Date2,IDName);

	CString strSelectOut,m;
	m="支出";

	strSelectOut.Format("SELECT 金额 FROM student_info_table WHERE 日期判 between #%s# and #%s# and 类型='%s' and 姓名='%s' ",
	Date1,Date2,m,IDName);

	
	CDaoRecordset set1(m_pDatabase);
	CDaoRecordset set2(m_pDatabase);
	int nItem = 0;
	try{			// 取记录集的数据
		set1.Open(dbOpenDynaset,strSelect);
		sum=0;
		while (!set1.IsEOF()) 
		{
			COleVariant var;
			var = set1.GetFieldValue(0);
			CString str=strVARIANT(var);
		
//			str = _T("");
			double i = _tcstod(str,0);  
			
		//	int i=_ttoi(str);
			sum=i+sum;
			set1.MoveNext();
		}
		CString show;
		show.Format(("%.2lf"),sum);
		CString results=show;
		m_strResult=results;
		UpdateData(0);
	}
		catch (CDaoException* e){
		e->ReportError(); 
		e->Delete();
		return;
	}
		
	int nItemOut = 0;
	try{			// 取记录集的数据
		set2.Open(dbOpenDynaset,strSelectOut);
		sumOut=0;
		while (!set2.IsEOF()) 
		{
			COleVariant varOut;
			varOut = set2.GetFieldValue(0);
			CString strOut=strVARIANT(varOut);
			double Z=_tcstod(strOut,0);
			sumOut=Z+sumOut;
			set2.MoveNext();
		}
		CString showOut;
		showOut.Format(("%.2lf"),sumOut);
		CString resultsOut=showOut;
		m_strOut=resultsOut;
		UpdateData(0);
	}
	catch (CDaoException* e){
		e->ReportError(); 
		e->Delete();
		return;
	}
		
	double outN=_tcstod(m_strOut,0);
	double sumN=_tcstod(m_strResult,0);
	haveN=sumN-outN;
	CString have;
	have.Format(("%.2lf"),haveN);
	CString haveK;
	haveK=have;
	m_strHave=have;
	UpdateData(0);
}

void CStatistics::OnInitialUpdate() 
{
	CFormView::OnInitialUpdate();
	CString strFileName="TVXQ_Save_1997.mdb"; //获取文件名以及路径名
	m_DBFileName = strFileName;
	//	m_strStatic1 = strFileName;
	UpdateData(false);

	
	//打开数据库，创建记录集合对象
	m_pDatabase = new CDaoDatabase;
	try{
		m_pDatabase->Open(m_DBFileName);
		m_pRecordset = new CDaoRecordset(m_pDatabase);
		m_ctrlList2.EnableWindow(true);
	}
	catch (CDaoException* e){
		e->ReportError();
		delete m_pDatabase;
		m_pDatabase = NULL;
		e->Delete();
		return;
	}

	CWnd* pWnd;
	pWnd=GetDlgItem(IDC_BUTTON3);
	pWnd->EnableWindow(false);

	
	UpdateView();  //在这函数中读取数据库
					//并更新ListView
	// TODO: Add your specialized code here and/or call the base class
	
}

bool CStatistics::UpdateView()
{
	//显示部分：清除当前的List
	m_ctrlList2.EnableWindow(true);
	m_ctrlList2.DeleteAllItems();
	while (m_ctrlList2.DeleteColumn(0))
	{
		m_ctrlList2.DeleteColumn(0);
	}
	int nListCol = m_ctrlList2.GetHeaderCtrl()->GetItemCount();//获取列数量
	if (nListCol > 0)
	{	for (int i=0;i<nListCol;i++)
	{	m_ctrlList2.DeleteColumn(i);
	}
	}
	
	//读取数据库中的“student_info_table”表的结构
	//写入FormView中的CListCtrl控件中。
	m_strTableName = _T("student_info_table");	// 设置当前操作的数据库表名称
	int nFields;
	CDaoFieldInfo fieldInfo;			// 取表的结构信息
	CDaoTableDef td(m_pDatabase);		// 表对象
	try{
		td.Open(m_strTableName);		//打开指定名称的表
		nFields = td.GetFieldCount()-3;	//获取该表的栏数
		for (int j=0; j < nFields; j++){
			td.GetFieldInfo(j,fieldInfo); //获取每个栏的信息
			int nWidth = m_ctrlList2.GetStringWidth(fieldInfo.m_strName) + 15;
			m_ctrlList2.InsertColumn(j,fieldInfo.m_strName,LVCFMT_LEFT, nWidth);
		}
	}catch (CDaoException* e){
		e->ReportError(); 
		e->Delete();
		return false;
	}
	td.Close();

	
	
	//读取表的数据，写入FormView中的CListCtrl控件中。
	int nItem = 0;
	try{
		//拼一个SQL查询语句：select * from [student_info_table]
		CString strSelect(_T("Select * From ["));
		strSelect += m_strTableName;
		strSelect += _T("]");   
		//指定m_pRecordset类型为动态类型,同时查询

		strSelect.Format("SELECT * FROM student_info_table WHERE 姓名='%s' ",
		IDName);
		m_pRecordset->Open(dbOpenDynaset,strSelect);
		
		while (!m_pRecordset->IsEOF()) 
		{
			COleVariant var;
			var = m_pRecordset->GetFieldValue(0); //第0列
			m_ctrlList2.InsertItem(nItem,strVARIANT(var));
			for (int i=0; i < nFields; i++){
				var = m_pRecordset->GetFieldValue(i);
				CString strItem = strVARIANT(var);
				int width1 = m_ctrlList2.GetColumnWidth(i);
				int width2 = m_ctrlList2.GetStringWidth(strItem)+15;
				if (width2 > width1){
					m_ctrlList2.SetColumnWidth(i,width2);
				}
				m_ctrlList2.SetItemText( nItem,i,strItem);
			}
			nItem++;
			m_pRecordset->MoveNext();
		}
	}
	catch (CDaoException* e)
	{
		e->ReportError(); 
	e->Delete();
		return false;
	}
	
	return true;
}

void CStatistics::OnButton2() 
{
	// TODO: Add your control notification handler code here
	CMenuAll dlg;
	dlg.DoModal();
}

void CStatistics::OnButton3() 
{
	// TODO: Add your control notification handler code here

	int m;
	if (haveN==sumOut&&haveN==0)
	{
		MessageBox("神马都没有…统计神马？？？");
		m=1;
	}
	
	
	if (haveN>=sumOut*(-1)&&(m!=1))
	{
		CMainFrame *pMain=(CMainFrame *)AfxGetApp()->m_pMainWnd;
		pMain->SwitchToForm(IDD_FORMVIEW_Draw);
		m=2;
	}

	if (sumOut*(-1)>haveN&&(m!=2))
		MessageBox("入不敷出！不要统计了…");


}

HBRUSH CStatistics::OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor) 
{
	HBRUSH hbr = CFormView::OnCtlColor(pDC, pWnd, nCtlColor);
	
	// TODO: Change any attributes of the DC here

	if (pWnd->GetDlgCtrlID()==(IDC_STATIC))
	{
		pDC->SetBkMode(TRANSPARENT);
		pDC->SetTextColor(RGB(34,34,34));
		return HBRUSH(GetStockObject(HOLLOW_BRUSH));
	}

	// TODO: Return a different brush if the default is not desired
	return hbr;
}
