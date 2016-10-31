// MainFrm.cpp : implementation of the CMainFrame class
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include "Cassiopeia_313751158Doc.h"
#include "Cassiopeia_313751158View.h"

#include "MainFrm.h"
#include "Help.h"
#include "Statistics.h"
#include "Detail.h"
#include "Draw.h"
#include "Tab.h"



#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMainFrame

IMPLEMENT_DYNCREATE(CMainFrame, CFrameWnd)

BEGIN_MESSAGE_MAP(CMainFrame, CFrameWnd)
	//{{AFX_MSG_MAP(CMainFrame)
	ON_WM_CREATE()
	ON_COMMAND(ID_Menu_LogOut, OnMenuLogOut)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

static UINT indicators[] =
{
	ID_SEPARATOR,           // status line indicator
	ID_INDICATOR_CAPS,
	ID_INDICATOR_NUM,
	ID_INDICATOR_SCRL,
};

/////////////////////////////////////////////////////////////////////////////
// CMainFrame construction/destruction

CMainFrame::CMainFrame()
{
	// TODO: add member initialization code here
	
}

CMainFrame::~CMainFrame()
{
}

int CMainFrame::OnCreate(LPCREATESTRUCT lpCreateStruct)
{
	
	if (CFrameWnd::OnCreate(lpCreateStruct) == -1)
		return -1;
	
	if (!m_wndToolBar.CreateEx(this, TBSTYLE_FLAT, WS_CHILD | WS_VISIBLE | CBRS_TOP
		| CBRS_GRIPPER | CBRS_TOOLTIPS | CBRS_FLYBY | CBRS_SIZE_DYNAMIC) ||
		!m_wndToolBar.LoadToolBar(IDR_MAINFRAME))
	{
		TRACE0("Failed to create toolbar\n");
		return -1;      // fail to create
	}

	if (!m_wndStatusBar.Create(this) ||
		!m_wndStatusBar.SetIndicators(indicators,
		  sizeof(indicators)/sizeof(UINT)))
	{
		TRACE0("Failed to create status bar\n");
		return -1;      // fail to create
	}

	// TODO: Delete these three lines if you don't want the toolbar to
	//  be dockable
	m_wndToolBar.EnableDocking(CBRS_ALIGN_ANY);
	EnableDocking(CBRS_ALIGN_ANY);
	DockControlBar(&m_wndToolBar);

	AfxGetModuleState()->m_dwVersion = 0x0601; 

	return 0;
}

BOOL CMainFrame::PreCreateWindow(CREATESTRUCT& cs)
{
	if( !CFrameWnd::PreCreateWindow(cs) )
		return FALSE;
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	cs.style &= ~WS_MAXIMIZEBOX; //禁止窗口最大化
	cs.style &= ~WS_THICKFRAME;//使窗口不能用鼠标改变大小

	 cs.cx = 1010;
     cs.cy = 615;

	 int xSize=::GetSystemMetrics(SM_CXSCREEN);
	 int ySize=::GetSystemMetrics(SM_CYSCREEN);

	 int z=xSize*9/10;
	 int u=ySize*9/10;

	 cs.x=((xSize-z)/2)+120;

	 cs.y=(ySize-u)/2;

		 
	return TRUE;

}

/////////////////////////////////////////////////////////////////////////////
// CMainFrame diagnostics

#ifdef _DEBUG
void CMainFrame::AssertValid() const
{
	CFrameWnd::AssertValid();
}

void CMainFrame::Dump(CDumpContext& dc) const
{
	CFrameWnd::Dump(dc);
}

#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMainFrame message handlers

void CMainFrame::SwitchToForm(int nForm) 
{ 
	//CDocument* pDoc = GetActiveDocument(); 
    CView *pOldActiveView=GetActiveView();             //保存旧视图 
    CView *pNewActiveView=(CView*)GetDlgItem(nForm);   //取得新视图 
    if(pNewActiveView==NULL) 
    { 
        switch(nForm) //这些ID是对话框的标志符,但也可以用其他的标志
        { 
        case IDD_FORMVIEW_Detail : 
            pNewActiveView=(CDetail*)new CDetail; 
            break; 
        case IDD_FORMVIEW_Statistics : 
            pNewActiveView=(CStatistics*)new CStatistics; 
            break; 
		case IDD_CASSIOPEIA_313751158_FORM : 
            pNewActiveView=(CCassiopeia_313751158View*)new CCassiopeia_313751158View; 
            break; 
		case IDD_FORMVIEW_Draw : 
            pNewActiveView=(CDraw*)new CDraw; 
            break; 
		case IDD_FORMVIEW_Tab : 
            pNewActiveView=(CTab*)new CTab; 
            break; 

        } 
        CCreateContext context;   //将文挡和视图相连 
        context.m_pCurrentDoc=pOldActiveView->GetDocument(); 
		pNewActiveView->Create(NULL, NULL, WS_BORDER|WS_CHILD , 
        CFrameWnd::rectDefault, this, nForm, &context); 
        pNewActiveView->OnInitialUpdate(); 
    } 
    SetActiveView(pNewActiveView);        //改变活动的视图 
    pNewActiveView->ShowWindow(SW_SHOW);  //显示新的视图 
    pOldActiveView->ShowWindow(SW_HIDE);  //隐藏旧的视图 
	
    if(pOldActiveView->GetRuntimeClass() ==RUNTIME_CLASS(CDetail)) 
	{	pOldActiveView->SetDlgCtrlID(IDD_FORMVIEW_Detail); 
	}
	else if(pOldActiveView->GetRuntimeClass() ==RUNTIME_CLASS(CStatistics)) 
	{	pOldActiveView->SetDlgCtrlID(IDD_FORMVIEW_Statistics); 
	}
	else if(pOldActiveView->GetRuntimeClass() ==RUNTIME_CLASS(CCassiopeia_313751158View)) 
	{	pOldActiveView->SetDlgCtrlID(IDD_CASSIOPEIA_313751158_FORM); 
	}
	else if(pOldActiveView->GetRuntimeClass() ==RUNTIME_CLASS(CDraw)) 
	{	pOldActiveView->SetDlgCtrlID(IDD_FORMVIEW_Draw); 
	}
	else if(pOldActiveView->GetRuntimeClass() ==RUNTIME_CLASS(CTab)) 
	{	pOldActiveView->SetDlgCtrlID(IDD_FORMVIEW_Tab); 
	}

    pNewActiveView->SetDlgCtrlID(AFX_IDW_PANE_FIRST); 
	

	
    delete pOldActiveView;   //删除旧视图 
	
	RecalcLayout();              //调整框架窗口 
}

void CMainFrame::OnMenuLogOut() 
{
	// TODO: Add your command handler code here
	SwitchToForm(IDD_FORMVIEW_Tab);
}
